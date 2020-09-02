package com.lucky.reponse;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_shop_info
 * @author 
 */
@Table(name = "t_shop_info")
@Data
public class TShopInfo implements Serializable {
    /**
     * 主键
     */
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
    private Boolean lift;

    /**
     * 面积
     */
    private BigDecimal squareSize;

    /**
     * 座位数
     */
    private Integer seatCount;

    /**
     * 门店类型
     */
    private Boolean shopType;

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
    private Boolean eatIn;

    /**
     * 是否支付配送
     */
    private Boolean dispatch;

    /**
     * 门店状态
     */
    private Integer status;

    /**
     * 开业时间
     */
    private Date setUpTime;

    /**
     * 停业时间
     */
    private Date shutUpTime;

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
     * 强制关闭门店, 1 闭店，0 不闭店
     */
    private Boolean focusClosed;

    /**
     * 强制停止配送，1 停止配送，0： 可以配送
     */
    private Boolean focusStopDispatch;

    /**
     * 客户端影像是否开启：1：是，0：否
     */
    private Boolean openVideo;

    /**
     * 当前售卖开始时间
     */
    private String currentSaleStartTime;

    /**
     * 当前售卖结束时间
     */
    private String currentSaleEndTime;

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
    private Date createTime;

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
    private Date lastModifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 当前配送开始时间
     */
    private String currentDispatchStartTime;

    /**
     * 当前配送结束时间
     */
    private String currentDispatchEndTime;

    /**
     * 是否为内部店, 1：是,0：否
     */
    private Boolean internal;

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
     * 支持运营模式, 到店：1 ，配送：2，3：到店加配送
     */
    private Byte operationMode;

    /**
     * app门店图片详情
     */
    private String appImgUrl;

    /**
     * 门店模式:0服务店,1自助店
     */
    private Byte shopModel;

    /**
     * 是否享受企业优惠:0否,1是
     */
    private Byte enjoyEntPref;

    /**
     * 是否配置提成：1：是，0：否
     */
    private Boolean commission;

    /**
     * 是否自动接单 0:否,1是
     */
    private Byte autoReceipt;

    /**
     * 现制商品自动接单上限
     */
    private Integer autoReceiptUp;

    /**
     * 特殊营业时间方案ID
     */
    private Long specialSaleTimePlanId;

    /**
     * 特殊派送时间方案id
     */
    private Long specialDispatchTimePlanId;

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
     * 强制停止配送原因
     */
    private String focusStopDispatchReason;

    /**
     * 强制闭店原因
     */
    private String focusClosedReason;

    /**
     * 强制停止配送原因id
     */
    private Long focusStopDispatchId;

    /**
     * 强制闭店原因id
     */
    private Long focusClosedId;

    /**
     * 外购商品自动接单上限
     */
    private Integer purchaseAutoReceiptUp;

    /**
     * 是否接入美团，1：已接入，2：未接入
     */
    private Boolean meituanJoin;

    /**
     * 美团服务状态，1：正常，2：停用
     */
    private Boolean meituanServiceStatus;

    /**
     * 是否美团超时置休，1：否，2：是，超时置休
     */
    private Boolean meituanSetRest;

    /**
     * 美团APP方门店ID
     */
    private String meituanAppPoiCode;

    /**
     * 是否计划闭店 1:计划闭店，0 不计划闭店
     */
    private Boolean planClose;

    /**
     * 计划闭店开始时间
     */
    private Date planCloseStartTime;

    /**
     * 计划闭店结束时间
     */
    private Date planCloseEndTime;

    /**
     * 是否支持预约，1：支持，2：不支持
     */
    private Integer reservation;

    /**
     * 计划闭店原因ID
     */
    private Long planCloseReasonId;

    /**
     * 计划闭店原因
     */
    private String planClosedReason;

    /**
     * 计划闭店备注
     */
    private String planCloseRemark;

    private static final long serialVersionUID = 1L;

}