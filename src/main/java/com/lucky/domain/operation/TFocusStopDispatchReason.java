package com.lucky.domain.operation;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 强制停止配送原因
 *
 * @author yanxue.kang
 */

@Data
@Table(name ="t_focus_stop_dispatch_reason")
public class TFocusStopDispatchReason implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 强制停止配送原因
     */
    private String reason;

    /**
     * 1: 有效，0：无效
     */
    private Integer status;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建人名称
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Long lastModifyBy;

    /**
     * 最后修改人名称
     */
    private String lastModifierName;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastModifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 原因编号
     */
    private String reasonNo;


}
