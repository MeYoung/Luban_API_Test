package com.lucky.params.luban;

import lombok.Data;

/**
 * Created by shijin.huang on 2019/7/2
 * <p>
 * 订单预览界面
 */
@Data
public class OrderDTO {
    /**
     * uid 和 userName 必须传入一个
     */
    private String uid;
    /**
     * baseurl
     */
    private String baseURL;

    /**
     * userName
     */
    private String userName;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 店铺ID
     */
    private String deptId;

    /**
     * 订单类型
     * pick 自取
     * sent 配送
     */
    private OrderTypeEnum orderType;

    /**
     * 地址ID
     */
    private Long addressId;

    /**
     * 优惠券ID
     */
    private String couponId;

    /**
     * 商品件数
     */
    private Integer amount;

    /**
     * 冷热属性
     */
    private Integer temperAttributeCode;

    /**
     * 规格编码
     */
    private String standardCode;


    /**
     * 商品类型：
     * ProductTypeEnum.zhoubian 周边商品
     * ProductTypeEnum.other 其他商品
     */
    private ProductTypeEnum productType;

    /**
     * 每个类型商品数量
     */
    private Integer num;

    /**
     * 每个类型的商品需要多少种
     */
    private Integer productTypeNum;

    /**
     * 模糊搜索地址
     */
    private String addressKey;

    /**
     * 环境
     */
    private String env;
}
