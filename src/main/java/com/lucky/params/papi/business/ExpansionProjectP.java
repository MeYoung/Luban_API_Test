package com.lucky.params.papi.business;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by liping.li on 2020-05-15
 *
 * 新增暂存选址
 */

@Data
public class ExpansionProjectP {


    /**
     * 记点id, 第一次保存成功后返回，后面保存需要传入
     */
    private Long id;

    /**
     * 记点项目名称
     */
    private String projectName;

    /**
     * 选址编号
     */
    private String projectNo;

    /**
     * 地址类型
     */
    private Integer addrLocationType;

    /**
     * 门店类型
     */
    private Integer shopLevel;

    /**
     * 操作类型：用来标识调用该接口的操作行为
     * 0:保存
     * 1:修改选址内容
     */
    private Integer operate;

    /**
     * 0 暂存
     * 1 提交
     */
    private Integer projectState;

    /**
     * pictureUrlMap：key为PictureTypeEnum,value为url数组
     * <p>
     * TWO_KILOMETRE_RANGE 两公里范围
     * SHOP_NEAR 门店附近图
     * SHOP_FLAT 门店平面图
     * SHOP_ENTRANCE 入口图片
     * FULL_VIEW 全景
     * NEAR_STREET 附近街道
     */
    private Map<String, List<String>> pictureUrlMap;

    /**
     * 品牌：1 小鹿茶，2 咖啡
     */
    private String brandId;

    /**
     * 项目类型
     * 枚举 ProjectTypeEnum =1 门店/2 仓库/3 附属仓库/4 前置仓
     */
    private Integer projectType;

    /**
     * 详细地址
     */
    private String addrAddress;

    /**
     * 城市区域
     */
    private String addrArea;

    /**
     * 门店城市
     */
    private String addrCity;

    /**
     * 精度
     */
    private String addrLongitude;

    /**
     * 纬度
     */
    private String addrLatitude;

    /**
     * 所属街道 *
     */
    private String addrStreet;

    /**
     * 所在楼层（层）*
     */
//    private Map<String, List<String>> addrFloor;
//    private List<String> addrFloor;
    private String addrFloor;


    /**
     * 建筑面积（㎡）*
     */
    private String addrBuildingArea;

    /**
     * 使用面积（㎡）*
     */
    private String addrUsingArea;

    /**
     * 是否为已开业城市*
     */
    private Boolean addrIsOpenCity;

    /**
     * 租金（元/月）*
     */
    private BigDecimal costHirePerMonth;

    /**
     * 每平米日租金（元）*
     */
    private BigDecimal costHireSqmPerDay;

    /**
     * 租期（月）*
     */
    private BigDecimal costHireDuration;

    /**
     * 免租期（天）*
     */
    private Integer costHireFreeDays;

    /**
     * 入场费（元）*
     */
    private BigDecimal costDoorMoney;

    /**
     * 转让费（元）*
     */
    private BigDecimal costTransferMoney;

    /**
     * 中介费（元）*
     */
    private BigDecimal costAgencyMoney;

    /**
     * 物业费（元/月）*
     */
    private BigDecimal costPropertyMoney;

    /**
     * 增容费用（元）*
     */
    private BigDecimal costCapacityIncreaseMoney;

    /**
     * 上水管径（mm）*
     */
    private BigDecimal siteUpperHoseDia;

    /**
     * 下水管径（mm）*
     */
    private BigDecimal siteDownHoseDia;

    /**
     * 上下水改造情况*
     */
    private String siteHoseRemouldDesc;

    /**
     * 是否可改为动力电*
     */
    private Boolean siteCanDynamicPower;

    /**
     * 供电（KW）*
     */
    private BigDecimal sitePowerSupply;

    /**
     * 是否有中央空调*
     */
    private Boolean siteIsCentralAcs;

    /**
     * 小于36㎡店铺是否有储物空间（仓库）
     */
    private Boolean siteHasStoringSpace;


    /**
     * 可营业时间*
     */
    private String siteOpenHours;

    /**
     * 写字楼面积（㎡）*
     */
    private BigDecimal siteOfficeBuildingArea;

    /**
     * 写字楼层数（层）*
     */
//    private Map<String, List<String>> siteOfficeBuildingFloorCount;
    private String siteOfficeBuildingFloorCount;

    /**
     * 入住率
     */
    private BigDecimal siteOfficeBuildingTakeRate;

    /**
     * 人数
     */
    private Integer siteOfficeBuildingPersonCount;

    /**
     * 是否有广告位*
     */
    private Boolean siteHasAdSpace;

    /**
     * 是否需要装修图纸报审*
     */
    private Boolean siteCheckDecorationPlan;

    /**
     * 是否需要进场装修材料*
     */
    private Boolean siteNeedDecorateionStuff;

    /**
     * 是否需要报消防*
     */
    private Boolean siteNeedFireDeclare;

    /**
     * 后区是否可加装外挂空调*
     */
    private Boolean siteEacInstallable;

    /**
     * 是否满足基本条件纵深2.5m，长6.5m*
     */
    private Boolean siteDeepEnough;

    /**
     * 6分钟门前人流/时间如：98/10:00；
     */
    private String siteFlowRateSixMin;

    /**
     * 消防是否需要改动*
     */
    private Boolean siteFireNeedAdjust;

    /**
     * 是否有消防栓*
     */
    private Boolean siteHasFireHydrant;

    /**
     * 能否办理证照*
     */
    private Boolean siteLicensable;

    /**
     * 合伙人姓名
     */
    private String thirdName;

    /**
     * 合伙人编号
     */
    private String thirdParterNo;

    /**
     * 合伙人电话
     */
    private String thirdPhone;

    /**
     * 签约状态
     */
    private String thirdStatus;


    /**
     * 意向编号
     */
    private String thirdPurpose;

    /**
     * 订单号
     */
    private String thirdOrderNo;

    /**
     * 是否为产权人*
     */
    private Boolean thirdIsOwner;

    /**
     * 产权性质
     */
    private String thirdOwnerShip;

    /**
     * 合作模式
     */
    private String addrCooperationMode;

    /**
     * 物业费
     */
    private BigDecimal costCondoMoney;


    /**
     * 押金费用
     */
    private BigDecimal costGuaranteeMoney;

    /**
     * 已开门店距离
     */
    private String siteNearestShopOpenedDistance;

    /**
     * 是否有店招
     */
    private boolean siteHasShopFor;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 最新修改时间
     */
    private String lastModifyTime;

    /**
     * 顾问
     */
    private String thirdCounselor;

    /**
     * 门店类型
     */
    private Integer addrStoreType;
}
