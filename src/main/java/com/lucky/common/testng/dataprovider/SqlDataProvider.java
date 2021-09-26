package com.lucky.common.testng.dataprovider;

import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import com.lucky.common.testng.dataprovider.sql.SqlMap;
import com.lucky.common.utils.BaseDataUtils;
import com.lucky.common.utils.EnvReaderUtils;
import com.lucky.common.utils.SQLExecuteUtils;
import com.lucky.params.BaseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author shijin.huang
 * @Date 2021/09/26
 */
@Slf4j
public class SqlDataProvider {


    @DataProvider(name = OTPDataProvider.NAME)
    public Iterator<Object[]> dataSql(Class testClass, Method testMethod, ITestContext c) {
        OTPDataProvider otpDataProvider =testMethod.getAnnotation(OTPDataProvider.class);
        String sqlQuery = otpDataProvider.sqlQuery();
        String sqlConfigID = otpDataProvider.sqlConfigID();
        return getData(sqlQuery, sqlConfigID);
    }


    public static Iterator<Object[]> getData(String sqlQuery, String sqlConfigName) {
        BaseData baseData = BaseDataUtils.getBaseData();
        String dbConfigID = "";
        try {
            EnvReaderUtils envReaderUtils = new EnvReaderUtils(baseData.getEnv() + ".properties");
            dbConfigID = envReaderUtils.getValue(sqlConfigName);

        } catch (Exception e) {
            log.error("BaseData 中的 env 是空值！！！", e);
        }
        SqlSession sqlSession = SQLExecuteUtils.run(dbConfigID);
        //        注册SqlMap 等同在MyBatisConfig.mxl 设定了 mappers
        sqlSession.getConfiguration().addMapper(SqlMap.class);
        List<Map<String, Object>> list = sqlSession.getMapper(SqlMap.class).getPublicItems(sqlQuery);
        List<Object[]> arrayList = DataProviderUtil.map2Obj(list);
        sqlSession.close();
        return arrayList.iterator();
    }


    public static void main(String[] args) {
        BaseData baseData = new BaseData();
        baseData.setEnv("test");
        BaseDataUtils.setBaseData(baseData);
        Iterator<Object[]> iterator = getData("select * from t_adjust_time limit 10", "db.operation");
        for (Iterator<Object[]> it = iterator; it.hasNext(); ) {
            Object object = iterator.next();
            Object object2 = JSONObject.toJSON(object);
            log.info(object2.toString());
        }

    }

}
