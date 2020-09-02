package com.lucky.params.papi.business;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by liping.li on 2020-05-16
 * <p>
 * 保存完善合同信息 参数q
 */

@Data
public class SavePerfectContractP {


    /**
     * 意向项目编号
     */
    private String applyProjectNo;


    /**
     * 水质类型（1：一类水质； 2：二类水质）
     */
    private Integer waterQualityType;


    /**
     * 水质,城市无水质报告，计算三个水质平均值。(无水质，必填)
     */
    private BigDecimal waterQuality;


    /**
     * 是否要装修图纸(1：是；2：否)
     */
    private Integer designDrawingFlag;
}
