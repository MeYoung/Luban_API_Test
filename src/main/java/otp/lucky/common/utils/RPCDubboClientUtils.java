/*
package com.lucky.common.utils;

import com.lucky.params.BaseData;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

*/
/**
 * @author shijin.huang
 * @date 2020/01/16
 * @content RPC client
 *//*

public class RPCDubboClientUtils {

    */
/**
     * 类似@Reference功能，获取bean
     * RPC调用时走负载均衡
     *
     * @param interfaceClass bean类
     * @return bean
     *//*

    public static <T> T getService(Class<T> interfaceClass) {
        BaseData baseData = BaseData.getInstance();
        ReferenceConfig<T> reference = new ReferenceConfig<T>();
        reference.setApplication(new ApplicationConfig(baseData.getData("AppName")));
//        连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
//        zookeeper 注册中心类型
        registry.setAddress(baseData.getZkAddress());
//        多个注册中心可以用setRegistries()
        reference.setRegistry(registry);
//        设置版本
        reference.setVersion(baseData.getVersion());
//        设置组
        reference.setGroup(baseData.getGroup());
//        设置服务接口
        reference.setInterface(interfaceClass);
//        设置服务方法调用超时是时间，单位毫秒
        reference.setTimeout(10000);
//        负载均衡策略，可选值：random,roundrobin,leastactive，分别表示：随机，轮询，最少活跃调用
        reference.setLoadbalance("leastactive");
//        返回目标接口
        return reference.get();
    }


    public static <T> T getService(Class<T> interfaceClass, String version) {
        BaseData baseData = BaseData.getInstance();
        ReferenceConfig<T> reference = new ReferenceConfig<T>();
        reference.setApplication(new ApplicationConfig(baseData.getAppName()));
//        连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
//        zookeeper 注册中心类型
        registry.setAddress(baseData.getZkAddress());
//        多个注册中心可以用setRegistries()
        reference.setRegistry(registry);
//        设置版本
        reference.setVersion(version);
//        设置组
        reference.setGroup(baseData.getGroup());
//        设置服务接口
        reference.setInterface(interfaceClass);
//        设置服务方法调用超时是时间，单位毫秒
        reference.setTimeout(10000);
//        负载均衡策略，可选值：random,roundrobin,leastactive，分别表示：随机，轮询，最少活跃调用
        reference.setLoadbalance("leastactive");
//        返回目标接口
        return reference.get();
    }

    */
/**
     * 类似@Reference功能，获取bean
     * RPC调用时直接指定请求到某台机器上，并调用某个版本和某个组
     *
     * @param interfaceClass bean类
     * @param dubboUrl       dubbo地址 如 dubbo://10.104.116.27:20880?version=1.0.0&group=dubbo
     * @param env            环境
     * @param <T>
     * @return bean
     *//*

    protected static <T> T getService(Class<T> interfaceClass, String dubboUrl, String env, String appName) {
        ReferenceConfig<T> reference = new ReferenceConfig<T>();
        reference.setApplication(new ApplicationConfig(appName));
        reference.setUrl(dubboUrl);
        reference.setInterface(interfaceClass);
        reference.setTimeout(10000);
        return reference.get();
    }
}
*/
