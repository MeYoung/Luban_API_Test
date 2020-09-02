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
@Table(name ="t_sale_goods")
public class TSaleGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 门店ID
     */
    private Long shopId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 售卖状态：0,1,2（不售、暂停售卖、售卖）
     */
    private Integer saleStatus;

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
     * 商品是否分不同size,1表示是，0表示否
     */
    private Integer distinguishSize;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 最后修改人名字
     */
    private String lastModifierName;

    /**
     * 商品的状态，0:已创建,1:已配置完成,2:已上线,3:已下线
     */
    private Integer status;

    /**
     * 商品库存类型(1:可售卖库存与商品库存相同,2:可售卖库存与商品库存不同)
     */
    private Integer stockType;

    /**
     * 销售的商品的库存size，大：1，中：2，小：4，模式相加
     */
    private Integer saleSizes;

    /**
     * 销售的商品的冰热属性，热：1 ，冷：2，常温：4 ，模式相加
     */
    private Integer saleTemperatures;

    /**
     * 品牌主数据编号
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;


}
