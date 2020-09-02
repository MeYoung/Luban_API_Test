package com.lucky.params.papi.withdrawablecash;

import lombok.Data;

import java.util.Date;

/**
 * @Author admin
 * @ModifyTime 2020/4/28 9:36
 * @Description 银行各更换请求参数
 */
@Data
public class BankCardUpdateParam {
    /**
     * 真实账户id
     */
    private Long id;
    /**
     * 主体id
     */
    private Long financeBodyId;
    /**
     * 真实账户类型id
     */
    private Long accountTypeId;
    /**
     * 真实账户类型名称
     */
    private String accountTypeName;
    /**
     * 金融机构类型
     */
    private Integer financeInstituteType;
    /**
     * 资金类型
     */
    private Integer fundsType;
    /**
     * 开户行id
     */
    private String bankMid;
    /**
     * 开户行名称
     */
    private String bankName;
    /**
     * 支行id
     */
    private String subBankMid;
    /**
     * 支行名称
     */
    private String subBankName;
    /**
     * 真实账户账号
     */
    private String accountNo;
    /**
     * 真实账户账户名
     */
    private String accountName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态(0:禁用，1:正常)
     */
    private Integer status;
    /**
     * 账户类型(0：对私，1：对公)
     */
    private Integer accountType;
    /**
     * 证明图片(对私：银行卡正面，对公：开户许可证)
     */
    private String realAccountImg;
    /**
     * 新建人id
     */
    private Long createUid;
    /**
     * 新建时间
     */
    private Date createTime;
    /**
     * 新建人名称
     */
    private String creatorName;

    private String userIdCard;


    private String mobilePhone;
}
