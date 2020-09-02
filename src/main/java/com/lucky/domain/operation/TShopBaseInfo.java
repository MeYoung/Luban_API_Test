package com.lucky.domain.operation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 门店基础信息表
 *
 * @author shijin.huang
 */

@Data
@Table(name ="t_shop_base_info")
public class TShopBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 门店序号
     */
    private String sequenceNumber;

    /**
     * 编号
     */
    private String shopNo;

    /**
     * 负责人姓名
     */
    private String managerName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 城市名
     */
    private String cityName;

    /**
     * 经度
     */
    private BigDecimal locationLongitude;

    /**
     * 纬度
     */
    private BigDecimal locationLatitude;

    /**
     * GEO 13 哈希字符串
     */
    private String locationL13;

    /**
     * GEO 14 哈希字符串
     */
    private String locationL14;

    /**
     * 地址
     */
    private String address;

    /**
     * 楼层
     */
    private String floorNumber;

    /**
     * 是否有电梯
     */
    private Integer lift;

    /**
     * 使用面积
     */
    private BigDecimal squareSize;

    /**
     * 座位数
     */
    private Integer seatCount;

    /**
     * 门店类型
     */
    private Integer shopType;

    /**
     * 门店级别
     */
    private Integer shopLevel;

    /**
     * 商品价位级别
     */
    private Long shopPriceLevel;

    /**
     * 堂食
     */
    private Integer eatIn;

    /**
     * 是否支付配送
     */
    private Integer dispatch;

    /**
     * 开业时间
     */
    private LocalDateTime setUpTime;

    /**
     * 停业时间
     */
    private LocalDateTime shutUpTime;

    /**
     * 门店图片
     */
    private String shopIcon;

    /**
     * 营业时间方案ID
     */
    private Long saleTimePlanId;

    /**
     * 派送时间方案id
     */
    private Long dispatchTimePlanId;

    /**
     * 配送范围
     */
    private String dispatchRange;

    /**
     * 是否为内部店, 1：是,0：否
     */
    private Integer internal;

    /**
     * 内部店二维码编号
     */
    private String internalQrcode;

    /**
     * 区域id
     */
    private Integer districtId;

    /**
     * 区域名
     */
    private String districtName;

    /**
     * 支持运营模式，1：到店，2配送，3：全部
     */
    private Integer operationMode;

    /**
     * 特殊营业时间方案ID
     */
    private Long specialSaleTimePlanId;

    /**
     * 特殊派送时间方案id
     */
    private Long specialDispatchTimePlanId;

    /**
     * app门店图片详情
     */
    private String appImgUrl;

    /**
     * 门店模式:0服务店,1自助店
     */
    private Integer shopModel;

    /**
     * 门店消防图
     */
    private String shopEscapePicture;

    /**
     * 门店平面图
     */
    private String shopPlanePicture;

    /**
     * 建筑面积
     */
    private BigDecimal buildSquareSize;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 门店主数据编号
     */
    private String shopMainNo;

    /**
     * 门店数据类型，1：真实门店，2：测试用门店
     */
    private Boolean conformType;

    /**
     * 门店完善状态，1：完善，0：未完善
     */
    private Integer perfectStatus;

    /**
     * 门店类型名称
     */
    private String shopTypeName;

    /**
     * 运营合作模式主数据编号：直营，代理
     */
    private String cooperationMainDataNo;

    /**
     * 运营合作模式名称：直营，代理
     */
    private String cooperationName;

    /**
     * 品牌主数据编号
     */
    private String brandMainDataNo;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 合伙人编号
     */
    private String partnerNo;

    /**
     * 合伙人名称
     */
    private String partnerName;

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
     * 是否有后区, 1：是,2：否
     */
    private Integer backArea;

    /**
     * 是否有仓库, 1：是,2：否
     */
    private Integer repository;


}
