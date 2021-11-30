
package otp.lucky.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import otp.lucky.params.BaseData;
import otp.lucky.params.Env;


/**
 * @author shijin.huang
 * @date 2020/01/16
 * @content RPC client
 */
@Slf4j
public class RPCClientUtil {


    /**
     * 类似@Reference功能，获取bean
     * RPC调用时走负载均衡
     *
     * @param interfaceClass bean类
     * @return bean
     */
    public static <T> T getService(Class<T> interfaceClass) {
        String env = BaseData.getInstance().getEnv();
        if (null == env || "".equals(env)) {
            log.error("BaseData的env值为空，请先设定RPC执行的环境!!");
            return null;
        }
        String zkAddress = PropertiesUtil.getValue(env + ".zk.address");
        String version = PropertiesUtil.getValue("dubbo.rpc.version");
        String group = PropertiesUtil.getValue("dubbo.rpc.group");
        String appName = PropertiesUtil.getValue("dubbo.rpc.appName");
        return getService(interfaceClass, zkAddress, appName, version, group);
    }

    /**
     * 后去RPC 服务，
     *
     * @param interfaceClass
     * @param version        rpc 版本
     * @param group          rpc所在组
     * @return
     */
    public static <T> T getService(Class<T> interfaceClass, String version, String group) {
        String env = BaseData.getInstance().getEnv();
        if ("".equals(env) || null == env) {
            log.error("BaseData的env值为空，请先设定RPC执行的环境!!");
            return null;
        }
        String zkAddress = PropertiesUtil.getValue(env + ".zk.address");
        String appName = PropertiesUtil.getValue("dubbo.rpc.appName");
        return getService(interfaceClass, zkAddress, appName, version, group);
    }


    /**
     * RPC 调用
     *
     * @param interfaceClass
     * @param zkAddress      zk地址
     * @param appName        消费者名
     * @param version        版本
     * @param group          组
     * @param <T>
     * @returnn
     */
    public static <T> T getService(Class<T> interfaceClass, String zkAddress, String appName, String version, String group) {
        ReferenceConfig<T> reference = new ReferenceConfig<T>();
        reference.setApplication(new ApplicationConfig(appName));
//        连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
//        zookeeper 注册中心类型
        registry.setAddress(zkAddress);
//        多个注册中心可以用setRegistries()
        reference.setRegistry(registry);
//        设置版本
        reference.setVersion(version);
//        设置组
        reference.setGroup(group);
//        设置服务接口
        reference.setInterface(interfaceClass);
//        设置服务方法调用超时是时间，单位毫秒
        reference.setTimeout(30 * 1000);
//        负载均衡策略，可选值：random,roundrobin,leastactive，分别表示：随机，轮询，最少活跃调用
        reference.setLoadbalance("leastactive");
//        返回目标接口
        return reference.get();
    }


    /**
     * 类似@Reference功能，获取bean
     * RPC调用时直接指定请求到某台机器上，并调用某个版本和某个组
     *
     * @param interfaceClass bean类
     * @param dubboUrl       dubbo地址 如 dubbo://10.104.116.27:20880?version=1.0.0&group=dubbo
     * @return bean
     */
    protected static <T> T getService(Class<T> interfaceClass, String dubboUrl) {
        String appName = PropertiesUtil.getValue("dubbo.rpc.appName");
        ReferenceConfig<T> reference = new ReferenceConfig<T>();
        reference.setApplication(new ApplicationConfig(appName));
        reference.setUrl(dubboUrl);
        reference.setInterface(interfaceClass);
        reference.setTimeout(30 * 1000);
        return reference.get();
    }
}
