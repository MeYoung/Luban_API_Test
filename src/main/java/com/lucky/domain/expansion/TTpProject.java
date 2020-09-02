package com.lucky.domain.expansion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 代运营记点流程核心表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_tp_project")
public class TTpProject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;


    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 坐标点id
     */
    private Long pointId;

    /**
     * 品牌 小鹿茶，咖啡 对应的代码
     */
    private String brandId;

    /**
     * 项目类型
     */
    private Integer projectType;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目状态 
     */
    private Integer projectState;

    /**
     * 审核状态枚举
     */
    private Integer reviewState;

    /**
     * 经纬转换地理位置
     */
    private String addrAddress;

    /**
     * 城市名称
     */
    private String addrCity;

//    /**
//     * 位置经纬度
//     */
//    private Integer addrLonLat;

    /**
     * 所属街道
     */
    private String addrStreet;

    /**
     * 楼层
     */
    private String addrFloor;

    /**
     * 门店类型
     */
    private Integer addrStoreType;

    /**
     * 位置类型
     */
    private Integer addrLocationType;

    /**
     * 建筑面积
     */
    private BigDecimal addrBuildingArea;

    /**
     * 使用面积
     */
    private BigDecimal addrUsingArea;

    /**
     * 合作模式
     */
    private String addrCooperationMode;

    /**
     * 是否已开业城市
     */
    private Integer addrIsOpenCity;

    /**
     * 保护截止日期
     */
    private LocalDateTime addrProtectEndDate;

    /**
     * 保护项目项目编号
     */
    private String addrProtectProjectNo;

    /**
     * 允许重新发起日
     */
    private LocalDateTime addrReprotectDate;

    /**
     * 合伙人姓名
     */
    private String thirdName;

    /**
     * 合伙人联系方式
     */
    private String thirdPhone;

    /**
     * 意向编号
     */
    private String thirdPurpose;

    /**
     * 是否产权人
     */
    private Integer thirdIsOwner;

    /**
     * 产权性质
     */
    private String thirdOwnerShip;

    /**
     * 费用信息,租金/月
     */
    private BigDecimal costHirePerMonth;

    /**
     * 每平米日租金
     */
    private BigDecimal costHireSqmPerDay;

    /**
     * 租期，月
     */
    private BigDecimal costHireDuration;

    /**
     * 免租期 天
     */
    private String costHireFreeDays;

    /**
     * 转让费
     */
    private BigDecimal costTransferMoney;

    /**
     * 中介费
     */
    private BigDecimal costAgencyMoney;

    /**
     * 增容费用
     */
    private BigDecimal costCapacityIncreaseMoney;

    /**
     * 场地信息,上水管直径
     */
    private BigDecimal siteUpperHoseDia;

    /**
     * 下水管直径
     */
    private BigDecimal siteDownHoseDia;

    /**
     * 上下水管改造情况
     */
    private String siteHoseRemouldDesc;

    /**
     * 是否可改为动力电
     */
    private Integer siteCanDynamicPower;

    /**
     * 供电KW
     */
    private BigDecimal sitePowerSupply;

    /**
     * 是否有中央空调,ACS : air conditioning system
     */
    private Integer siteIsCentralAcs;

    /**
     * 小于36平米是否有储物空间
     */
    private String siteHasStoringSpace;

    /**
     * 可营业时间
     */
    private String siteOpenHours;

    /**
     * 写字楼面积
     */
    private BigDecimal siteOfficeBuildingArea;

    /**
     * 写字楼层数
     */
    private String siteOfficeBuildingFloorCount;

    /**
     * 写字楼入住率
     */
    private BigDecimal siteOfficeBuildingTakeRate;

    /**
     * 人数
     */
    private Integer siteOfficeBuildingPersonCount;

    /**
     * 周围楼宇
     */
    private String siteOfficeAround;

    /**
     *  已开最近门店
     */
    private String siteNearestShopOpened;

    /**
     *  已开最近门店距离
     */
    private Integer siteNearestShopOpenedDistance;

    /**
     * 是否有广告位
     */
    private Integer siteHasAdSpace;

    /**
     * 是否有店招
     */
    private Integer siteHasShopFor;

    /**
     * 是否需要装修图纸报审
     */
    private Integer siteCheckDecorationPlan;

    /**
     * 是否需要进场装修材料
     */
    private Integer siteNeedDecorateionStuff;

    /**
     * 是否需要报消防
     */
    private Integer siteNeedFireDeclare;

    /**
     * 是否可加装外挂空调,EAC：External air conditioning
     */
    private Integer siteEacInstallable;

    /**
     * 是否满足基本条件纵深
     */
    private Integer siteDeepEnough;

    /**
     *  物流配送时间
     */
    private String siteDeliveryTime;

    /**
     *  最早可配送时间
     */
    private String siteEarliestDeliveryTime;

    /**
     *  最晚可配送时间
     */
    private String siteLatestDeliveryTime;

    /**
     * 可装修时段
     */
    private String siteDecorationTime;

    /**
     * 是否有消防栓
     */
    private Integer siteHasFireHydrant;

    /**
     * 消防是否需要改动
     */
    private Integer siteFireNeedAdjust;

    /**
     * 水改造费用
     */
    private BigDecimal siteHoseAdjustMoney;

    /**
     * 污染源距离
     */
    private Integer sitePolluterDistance;

    /**
     * 能否办理证照
     */
    private Integer siteLicensable;

    /**
     * 预估商品数，日均
     */
    private Integer siteProductCountPerDay;

    /**
     *  6分钟门前人流
     */
    private String siteFlowRateSixMin;

    /**
     *  场地备注
     */
    private String siteRemark;

    /**
     * 创建人部门id
     */
    private Long deptId;

    /**
     * 所属区域
     */
    private Long region;

    /**
     * 新建人
     */
    private String createUser;

    /**
     * 创建人姓名
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastModifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 入场费
     */
    private BigDecimal costDoorMoney;

    /**
     * 选址信息，城市区域
     */
    private String addrArea;

    /**
     * 合伙人编号
     */
    private String thirdParterNo;

    /**
     * 订单号
     */
    private String thirdOrderNo;

    /**
     * 是否有意向
     */
    private Integer thirdInterested;

    /**
     * 物业费
     */
    private BigDecimal costCondoMoney;

    /**
     * 跟进顾问
     */
    private String thirdCounselor;

    /**
     * 保护期截止日
     */
    private LocalDateTime protectionDeadLine;

    /**
     * 允许重新发起日
     */
    private LocalDateTime allowRestartDate;

    /**
     * 0 扩建系统,1 合伙人系统 ,2 app
     */
    private Integer sourceType;

    /**
     * 门店级别枚举TpShopLevelEnum 
     */
    private Integer shopLevel;

    /**
     * lonlat 字符串格式
     */
    private String lonlatString;

    /**
     * 押金费用
     */
    private BigDecimal costGuaranteeMoney;

    /**
     * 未上传房租合同告知合伙人项目失效时间
     */
    private LocalDateTime pushInvalidTime;

    /**
     * 旧项目编号
     */
    private String oldProjectNo;

    /**
     * 冲突判断结果 1：冲突、2：无冲突
     */
    private Boolean conflictResult;

    /**
     * 状态最后流转时间
     */
    private LocalDateTime latestProcessTime;

    /**
     * 记录操作记录最后一次时间
     */
    private LocalDateTime latestOpLogTime;

    /**
     * 城市编号/ID
     */
    private String cityCode;


}
