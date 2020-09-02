package com.lucky.domain.operation;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;

import javax.persistence.Table;


/**
 * 商品售卖方案
 *
 * @author 
 */

@Data
@Table(name ="t_goods_sale_plan")
public class TGoodsSalePlan implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 方案编号
     */
    private String planNo;

    /**
     * 方案名称
     */
    private String planName;

    /**
     * 方案状态 2:无效 1 有效
     */
    private Integer planType;

    /**
     * 城市ID
     */
    private String cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 门店级别ID
     */
    private String shopLevelId;

    /**
     * 门店级别名称
     */
    private String shopLevelName;

    /**
     * 触发方式 1 手工同步 2 定时同步 3 按门店同步
     */
    private Integer triggerMode;

    /**
     * 同步时间
     */
    private LocalDateTime syncTime;

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
     * 触发方式按门店状态同步对应的门店状态
     */
    private Integer shopStatus;

    /**
     * 同步完成时间
     */
    private LocalDateTime syncEndTime;

    /**
     * 门店模式:1服务店,2自助店
     */
    private Integer shopModel;

    /**
     * 运营合作模式主数据编号：直营，代理
     */
    private String cooperationCode;

    /**
     * 运营合作模式名称：直营，代理
     */
    private String cooperationName;

    /**
     * 品牌主数据编号
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;


}
