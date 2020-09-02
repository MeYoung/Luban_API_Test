package com.lucky.common.utils;

import com.lucky.params.BaseData;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by shijin.huang on 2019/7/23
 */
@Slf4j
public class BaseDataUtils {
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
