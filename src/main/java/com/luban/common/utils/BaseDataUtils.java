package com.luban.common.utils;

import com.luban.params.BaseData;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by shijin.huang on 2019/7/23
 */
@Slf4j
public class BaseDataUtils {
//    单例模式 避免多线程运行多次初始化数据
    private static BaseData baseData = null;

    public synchronized static void setBaseData(BaseData targetData) {
        if (baseData == null) {
            baseData = targetData;
        }
    }

    public synchronized static BaseData getBaseData() {
        return baseData;
    }

/*    public static void setBaseData(BaseData targetData) {
            baseData = targetData;

    }

    public static BaseData getBaseData() {
        return baseData;
    }*/
}
