package com.lucky.params.papi.hotcommidity;

import lombok.Data;

/**
 * @author shue.li
 * @date 2020/6/9 15:27
 * @content 人气商品
 */
@Data
public class HotCommidityParam {
    //门店id
    private String deptShopId;
    //商品id
    private String commodityId;
    //商品名称
    private String commodityName;
    //商品编号
    private String goodNo;
    //商品大类
    private String oneCategoryId;
    //商品中类
    private String twoCategoryId;
    //商品小类
    private String threeCategoryId;
    //是否设为人气top，true：是，false：否
    private String isPopular;

}
