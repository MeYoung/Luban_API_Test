package com.lucky.domain.operation;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 订单售后参数配置表
 *
 * @author yuejie.ye
 */

@Data
@Table(name ="t_order_after_sales_configure")
public class TOrderAfterSalesConfigure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    /**
     * 订单可申请售后时长(天)
     */
    private Integer afterSaleTime;

    /**
     * 售后工单自动取消时长(天)
     */
    private Integer autoCancellationTime;

    /**
     * 仓库供货订单自动取消时长(天)
     */
    private Integer autoCancellationTimeForWarehouse;

    /**
     * 最后修改人id
     */
    private Long lastModifyBy;

    /**
     * 最后修改人名称
     */
    private String lastModifyName;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastModifyTime;


}
