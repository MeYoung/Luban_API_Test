package otp.lucky.params;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import otp.lucky.common.utils.EnumUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shijin.huang on 2019/7/20
 * <p>
 * 存放登录用户相关信息和公共全局变量
 */
@Slf4j
@Data
public class BaseData {

    private BaseData() {
    }

    /**
     * 说的volatile，首先肯定回答volatile的可见性
     * 防止重排序优化，如果不用volatile修饰，多线程的情况下，
     * 可能会出现线程A进入synchronized代码块，执行new BaseData();，
     * 首先给baseData分配内存，但是还没有初始化变量，这时候线程B进入getBaseData方法，进行第一个判断，
     * 此时baseData已经不为空，直接返回baseData，然后肯定报错。使用volatile修饰之后禁止jvm重排序优化。
     */
    private static volatile BaseData baseData;

    public static BaseData getInstance() {
        if (baseData == null) {
            synchronized (BaseData.class) {
                if (baseData == null) {
                    baseData = new BaseData();
                }

            }
        }
        return baseData;
    }

    /**
     * 方式二
     * 通过静态内部类也可以完成
     * 静态内部类拥有如下2个优点：
     * 1. 当BaseData类被装载时，静态内部类 BaseDataUtils 是不会被装载。 懒加载
     * 2. 当我们调用getBaseDataStaticClass() 是， BaseDataUtils才会被装载，被装载时是线程安全的。  线程安全
     */
    private static class BaseDataUtils {
        private static final BaseData BASE_DATA = new BaseData();
    }

    public static BaseData getInstanceStaticClass() {
        return BaseDataUtils.BASE_DATA;
    }

    /**
     * 服务环境 仅能使用 test03 test04 pre prod 字段
     */
    private Env env;

    public void setEnv(String env) {
        if (EnumUtil.isInclude(Env.class, env)) {
            Env envEnum = EnumUtil.likeValueOf(Env.class, env);
            this.env = envEnum;
        } else {
            log.error("环境名称有误，请使用 test03 、test04 、 pre 、 prod 中字符串!!!!");
            Assert.fail();
        }
    }

    public String getEnv() {
        return this.env.value();
    }

    Map<String, Object> data = new HashMap<>();

    public void setData(String key, Object value) {
        data.put(key, value);
    }

    public Object getData(String key) {
        return data.get(key);
    }

}
