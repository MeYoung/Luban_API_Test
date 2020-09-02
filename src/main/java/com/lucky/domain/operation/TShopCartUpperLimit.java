package com.lucky.domain.operation;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 
 *
 * @author 
 */

@Data
@Table(name ="t_shop_cart_upper_limit")
public class TShopCartUpperLimit implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 上限数量(旧)
     */
    private Integer upperLimit;

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
     * 自提订单外购商品上限数量
     */
    private Integer pickBuyLimit;

    /**
     * 自提订单现制商品上限数量
     */
    private Integer pickMakeLimit;

    /**
     * 外送订单外购商品上限数量
     */
    private Integer deliveryBuyLimit;

    /**
     * 外送订单现制商品上限数量
     */
    private Integer deliveryMakeLimit;

    /**
     * 品牌主数据编号
     */
    private String brandMainDataNo;


}
