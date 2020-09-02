package com.lucky.domain.operation;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 售卖商品的状态、尺寸、冷热属性的方案设置
 *
 * @author 
 */

@Data
@Table(name ="t_goods_sale_setup")
public class TGoodsSaleSetup implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 售卖状态：0,1,2（不售、暂停售卖、售卖）
     */
    private Integer saleStatus;

    /**
     * 售卖尺寸 详见GoodsSizeEnum 枚举
     */
    private Integer saleSizeType;

    /**
     * 商品的冰热属性 详见 CommodityTemperEnum 枚举
     */
    private Long temperature;

    /**
     * 商品售卖方案ID
     */
    private Long goodsSalePlanId;

    /**
     * 1: 有效，0：已删除
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
     * 商品是否分不同size,1表示是，0表示否
     */
    private Integer distinguishSize;

    /**
     * 商品库存类型(1:可售卖库存与商品库存相同,2:可售卖库存与商品库存不同)
     */
    private Integer stockType;

    /**
     * 商品的状态，0:已创建,1:已配置完成,2:已上线,3:已下线
     */
    private Integer onlineStatus;

    /**
     * 是否紧急停售 0否 1是
     */
    private Integer stopStatus;

    /**
     * 商品是否区分温度e,1表示是，0表示否
     */
    private Integer distinguishTemper;

    /**
     * 商品是否支持外卖(0:不支持,1:支持)
     */
    private Integer isTakeWay;

    /**
     * 品牌主数据编号
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;


}
