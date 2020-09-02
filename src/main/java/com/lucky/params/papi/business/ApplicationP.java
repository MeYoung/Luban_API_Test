package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-07-02
 */

@Data
public class ApplicationP {

    /**
     * 意向用户名
     */
    private String applyName;

    /**
     * 性别
     * 0 男
     * 1 女
     */
    private Integer applyGender;

    /**
     * email
     */
    private String email;


    /**
     * 现居地址
     */
    private String presentAddress;

    /**
     * 意向合作省份id
     */
    private Integer IntentionProvinceId;

    /**
     * 意向合作省份名称
     */
    private String IntentionProvinceName;

    /**
     * 意向合作城市名称
     */
    private String IntentionCityName;

    /**
     * 意向合作城市id
     */
    private Integer intentionCityId;

    /**
     * 选择合作原因
     * <p>
     * (1, "新零售模式"),
     * <p>
     * (2, "0加盟费"),
     * <p>
     * (3, "超强品牌"),
     * <p>
     * (4, "全域流量"),
     * <p>
     * (5, "其他");
     */
    private Integer startReason;


    /**
     * 预计投入总资金
     */
    private Integer investMoney;

    /**
     * (1, "本人"),
     * <p>
     * (2, "家人朋友"),
     * <p>
     * (3, "聘雇店长"),
     * <p>
     * (4, "其他");
     */
    private Integer whoManage;

    /**
     * (1, "全力投入亲自经营"),
     * <p>
     * (2, "家人朋友协助管理经营"),
     * <p>
     * (3, "聘雇专业人士"),
     * <p>
     * (4, "其他");
     */
    private Integer howManage;
}
