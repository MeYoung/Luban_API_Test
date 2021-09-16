package com.lucky.common.utils;

import com.lucky.params.BaseData;

public class BaseDataTools {

    private BaseDataTools() {
    }

    private static class Singletion {
        static final BaseDataTools baseDataTools = new BaseDataTools();
    }

    public static BaseDataTools getInstance() {
        return Singletion.baseDataTools;
    }


    static BaseData baseData;

    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }

    public BaseData getBaseData() {
        return baseData;
    }

}
