package com.lucky.domain.partner;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by liping.li on 2020-05-06
 *
 * t_partnerApply and t_partnerInfo 联表
 */


@Data
public class PartnerApplyInfo {


    /**
     * 申请人姓名
     */
    private String applyName;

    /**
     * 申请人电话
     */
    private String applyPhone;

    /**
     * 申请人所在城市
     */
    private String cityName;

    /**
     * 合作意向
     */
    private String cooperationIntention;

    /**
     * 自定义参数
     */
    private String customParameter;

    /**
     * 来源，参考枚举SourceEnum
     */
    private Integer source;

    /**
     * 新建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 新建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除，参考枚举IsDeleteEnum
     */
    private Integer isDelete;

    /**
     * 备注
     */
    private String remark;

    /**
     * 意向编号
     */
    private String applyNo;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 是否有店面
     */
    private Integer isExistShop;

    /**
     * 是否自己经营
     */
    private Integer isOperateSelf;

    /**
     * 从事行业
     */
    private String engageJob;

    /**
     * 客户进度
     */
    private Integer customerProgress;

    /**
     * 客户详细进度(取值于配置中心)
     */
    private Integer subCustomerProgress;

    /**
     * 下次沟通时间
     */
    private LocalDateTime nextConnectTime;

    /**
     * 意向城市ID
     */
    private Integer intentionCityId;

    /**
     * 意向城市名称
     */
    private String intentionCityName;

    /**
     * 招商会编号集合
     */
    private String investmentNos;

    /**
     * 顾问ID
     */
    private Integer advisorId;

    /**
     * 顾问名称
     */
    private String advisorName;

    /**
     * 客户意向，参考枚举CustomerIntentionEnum
     */
    private Integer customerIntention;

    /**
     * 沟通状态
     */
    private Integer communicationState;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 籍贯
     */
    private String birthOrigin;

    /**
     * 联络电话
     */
    private String contractPhone;

    /**
     * 婚姻状况 MaritalEnum
     */
    private Integer marital;

    /**
     * 子女人数 KidNumEnum
     */
    private Integer kidNum;

    /**
     * 配偶姓名
     */
    private String spouseName;

    /**
     * 配偶职业
     */
    private String spouseJob;

    /**
     * 现居地址
     */
    private String presentAddress;

    /**
     * 户籍地址
     */
    private String birthOriginAddress;

    /**
     * 申请人性别，参考枚举ApplyGenderEnum
     */
    private Integer applyGender;

    /**
     * 意向省份id
     */
    private Integer intentionProvinceId;

    /**
     * 意向省份名称
     */
    private String intentionProvinceName;

    /**
     * 征信查询结果CreditEnquiryResultEnum
     */
    private Integer creditEnquiryResult;

    /**
     * 是否完善合伙人信息 PerfectApplyFormStatus
     */
    private Integer perfectApplyFormStatus;

    /**
     * 面试结果，参考枚举InterviewResultEnum
     */
    private Integer interviewResult;

    /**
     * 跟进人ID
     */
    private Integer followerId;

    /**
     * 跟进人名称
     */
    private String followerName;

    /**
     * 应邀者ID
     */
    private Integer invitorId;

    /**
     * 应邀者名称
     */
    private String invitorName;

    /**
     * 面试单文件路径
     */
    private String interviewImgUrl;

    /**
     * 面试单文件名称
     */
    private String interviewImgName;


    /**
     * 合伙人编号
     */
    private String partnerNo;

    /**
     * 合伙人名称
     */
    private String partnerName;

    /**
     * 合伙人状态，参考枚举PartnerStatusEnum
     */
    private Integer partnerStatus;

    /**
     * 合作状态，参考枚举CooperationStatusEnum
     */
    private Integer cooperationStatus;

    /**
     * 新建人
     */
    private String creatorName;



    /**
     * 修改人
     */
    private String modifierName;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;



    /**
     * 合伙人类型，参考枚举PartnerTypeEnum
     */
    private String partnerType;

    /**
     * 证件号，组织机构编码/生份证号
     */
    private String certificateNo;

    /**
     * 支持品牌，参考枚举SupportBrandEnum
     */
    private String trademarkCode;

    /**
     * 审批时间
     */
    private LocalDateTime approvalTime;

    /**
     * 审批人
     */
    private String approvalName;


    /**
     * 身份证地址
     */
    private String certificateAddress;

    /**
     * 身份证正面文件路径
     */
    private String certificateFontUrl;

    /**
     * 身份证正面文件名称
     */
    private String certificateFontName;

    /**
     * 身份证反面文件路径
     */
    private String certificateBackUrl;

    /**
     * 身份证反面文件名称
     */
    private String certificateBackName;


}