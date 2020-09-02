package com.lucky.domain.partner;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 意向项目
 *
 * @author liping.li
 */

@Data
@Table(name ="t_partner_apply_project")
public class TPartnerApplyProject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 意向项目编号
     */
    private String applyProjectNo;

    /**
     * 意向项目名称
     */
    private String applyProjectName;

    /**
     * 合伙人编号
     */
    private String partnerNo;

    /**
     * 新建人
     */
    private String creatorName;

    /**
     * 新建时间
     */
    private LocalDateTime createTime;

    /**
     * 意向协议编号
     */
    private String contractNo;

    /**
     * 修改人
     */
    private String modifierName;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 意向编号
     */
    private String applyNo;

    /**
     * 品牌编码
     */
    private String trademarkCode;

    /**
     * 选址阶段是否真正确认品牌，BooleanEnum:1为是,2为否
     */
    private Integer isConfirmTrademark;

    /**
     * 统计数目
     */
    private Integer count;


}
