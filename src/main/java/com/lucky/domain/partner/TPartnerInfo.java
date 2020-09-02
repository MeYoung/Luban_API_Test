package com.lucky.domain.partner;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 合伙人基础信息表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_partner_info")
public class TPartnerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 新建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifierName;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 是否删除，参考枚举IsDeleteEnum
     */
    private Integer isDelete;

    /**
     * 备注
     */
    private String remark;

    /**
     * 关联意向编号
     */
    private String applyNo;

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
     * 记录更新时间
     */
    private LocalDateTime updateTime;

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
