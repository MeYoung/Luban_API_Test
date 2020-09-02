package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-05-06
 *
 * 品牌设置参数 q
 */

@Data
public class BrandSetupP {

    /**
     * 意向项目ID
     */
    private String applyProjectNo;
    /**
     * 品牌ID
     *
     * LUCKINCOFFEE("LK001", "luckin coffee"),
     * XIAOLUCHA("LK002", "小鹿茶");
     *
     */
    private String brandId;


    /**
     * 品牌ID (再次选择品牌)
     */
    private String trademarkCode;
}
