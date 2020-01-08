package com.luban.client;

import com.luban.common.utils.BaseDataUtils;
import com.luban.common.utils.EnvReaderUtils;
import com.luban.common.utils.RPCDubboClientUtils;
import com.luban.common.utils.SQLExecuteUtils;
import com.luban.params.BaseData;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * @author shijin.huang
 * @date 2020/1/8
 * @content
 */
@Slf4j
public class RpcClient extends RPCDubboClientUtils {
    @Parameters({"env"})
    @BeforeSuite
    public void initializationData(String env) {
        log.info(env);
        String appName = "xxxRPC";
        BaseData baseData = new BaseData();
        baseData.setEnv(env);
        baseData.setAppName(appName);
//        读取配置文件的数据
        EnvReaderUtils envReaderUtils = new EnvReaderUtils(env + ".properties");
        String dbOperation = envReaderUtils.getValue("db.operation");
        String zkAddress = envReaderUtils.getValue("zk.address");
        String version = envReaderUtils.getValue(appName + ".version.v1");
        String group = envReaderUtils.getValue(appName + ".group");
//        给baseData设置一些可能后面会用到的基础数据
        baseData.setZkAddress(zkAddress);
        baseData.setVersion(version);
        baseData.setGroup(group);

//       连接数据库
        SqlSession sessionOperation = SQLExecuteUtils.run(dbOperation);
        //  创建一个MapperHelper 注意每个库都需要创建
        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.processConfiguration(sessionOperation.getConfiguration());
        baseData.setSessionOperation(sessionOperation);
        //         必须初始化数据库和基础数据后set
        BaseDataUtils.setBaseData(baseData);
    }


    /**
     * 获取到 XXXXSerivice 服务,更加自己具体提供的RPC服务来
     *
     * @param version 版本，如果不传默认用配置文件的版本
     * @return
     */
    public XXXXSerivice xxxxSerivice(String... version) {
        if (version.length > 0) {
            return RPCDubboClientUtils.getService(XXXXSerivice.class, version[0]);
        } else {
            return RPCDubboClientUtils.getService(XXXXSerivice.class);
        }
    }


    @Attachment("关闭 数据库等 链接")
    @AfterSuite
    public void closed() {
        BaseData baseData = BaseDataUtils.getBaseData();
        if (baseData.getSessionOperation() != null) {
            baseData.getSessionOperation().close();
        }
        System.out.println("=================================================================================================");
        log.info("关闭资源完成！！！！！！");
        System.out.println("=================================================================================================");
    }
}
