package com.lucky.domain.partner;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 合同表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_contract")
public class TContract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 意向编号
     */
    private String applyNo;

    /**
     * 合伙人编号
     */
    private String partnerNo;

    /**
     * 门店编号
     */
    private String shopNo;

    /**
     * 业务分类（合同类型），参考枚举BusinessCategoryEnum
     */
    private Integer businessCategory;

    /**
     * 合同状态,参考枚举ContractStatusEnum
     */
    private Integer contractStatus;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 契约锁合同ID
     */
    private Long contractId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 合同名称
     */
    private String subject;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String modifyName;

    /**
     * 意向项目编号
     */
    private String applyProjectNo;

    /**
     * 系统状态（系统操作过程是否异常） 正常0，异常1 默认0
     */
    private Integer systemStatus;


}
