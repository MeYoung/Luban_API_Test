package com.lucky.domain.operation;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 
 *
 * @author 
 */

@Data
@Table(name ="t_sale_goods_detail")
public class TSaleGoodsDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 门店ID
     */
    private Long saleGoodsId;

    /**
     * 尺寸，大：1，中：2，小：3
     */
    private Integer sizeType;

    /**
     * 库存总量
     */
    private Integer stockCount;

    /**
     * 可销售量
     */
    private Integer saleableCount;

    /**
     * 用户可用库存
     */
    private Integer userCount;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Long lastModifyBy;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastModifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否紧急停售 0否 1是
     */
    private Integer stopStatus;

    /**
     * 更改salestatus的时间
     */
    private LocalDateTime modifyStatusTime;

    /**
     * 商品的冰热属性，0：不区分冰热，2：冰，1：热，3：常温
     */
    private Integer temperature;


}
