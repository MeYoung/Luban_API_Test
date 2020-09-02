package com.lucky.reponse.sapi.walletrecharge;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author shijin.huang
 * @date 2019-10-28
 * @content 充值单详情 reponse
 */

@Data
public class ListRe {

    /**
     * id
     */
    private Long id;


    /**
     * '充值单号'
     */
    private String rechargeNo;
    /**
     * 交易流水，存入三方平台
     */
    private String tpSerialNo;
    /**
     * 三方交易流水号
     */
    private String thirdSerialNo;
    /**
     * 会员ID
     */
    private Long memberId;
    /**
     * 会员手机号
     */
    private String memberPhone;
    /**
     * 充值方式
     */
    private Integer rechargeWay;
    /**
     * 充值方式描述
     */
    private String rechargeWayDesc;
    /**
     * 充值总金额
     */
    private BigDecimal rechargeAmount;
    /**
     * 付款方式
     */
    private Integer payWay;
    /**
     * 在线付款方式描述
     */
    private String payWayDesc;
    /**
     * 充值状态
     */
    private Integer status;
    /**
     * 充值状态描述
     */
    private String statusDesc;
    /**
     * 充值人id
     */
    private Long rechargeEmployeeId;
    /**
     * 充值人
     */
    private String rechargeEmployeeName;
    /**
     * 充值时间，精确到分钟
     */
    private String rechargeTime;
    /**
     * 附加照片，适用于POS刷卡支付
     */
    private List<String> photoUrlList;

}
