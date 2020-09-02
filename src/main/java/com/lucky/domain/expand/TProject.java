package com.lucky.domain.expand;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 项目表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_project")
public class TProject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目名称，原 初始门店名称shop_init_name
     */
    private String projectName;

    /**
     * 继承项目编号
     */
    private String inheritProjectNo;

    /**
     * 项目集ID
     */
    private Long projectSetId;

    /**
     * 项目主状态，原 主状态(1:正常 2:已暂停 3:已终止 4:已变更)
     */
    private Integer workStatus;

    /**
     * 流程状态:10-已新建(原1-待完善,10-已新建)，12-已提交项目(原12-已提交项目)，20-已项目确认(原20-已项目确认)，21-已项目退回(原21-已项目退回)，30- 已启动(原30-已启动，32-已启动退回，40-已出报审图,41-已物业审批退回，42-已出图退回，50-已上传装修合同，60-已交付运营，70-已运营确认，71-已运营退回，72-已发起重新装修)，81-提前启动待确认，82-提前启动退回
     */
    private Integer processStatus;

    /**
     * 启动方式，1:正常启动 2:提前启动
     */
    private Integer startupMode;

    /**
     * 启动日期，对应原t_project_batch中start_project_time_real
     */
    private LocalDateTime startupDate;

    /**
     * 选址编号
     */
    private String selectSiteNo;

    /**
     * 门店品牌编号
     */
    private String shopBrandCode;

    /**
     * 门店品牌名称
     */
    private String shopBrandName;

    /**
     * 合作模式(运营模式)编码
     */
    private String cooperationModelCode;

    /**
     * 合作模式(运营模式)名称
     */
    private String cooperationModelName;

    /**
     * 市ID（主数据）
     */
    private String cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 地区id
     */
    private Long districtId;

    /**
     * 地区名称
     */
    private String districtName;

    /**
     * 城市NCid(从EHR获取)
     */
    private String cityDeptId;

    /**
     * 所在商圈 
     */
    private String businessDistrict;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 门店类型编号: 枚举ShopTypeEnum
     */
    private String shopTypeCode;

    /**
     * 门店级别ID
     */
    private String shopLevelId;

    /**
     * 门店级别
     */
    private String shopLevelName;

    /**
     * 建筑面积
     */
    private BigDecimal floorArea;

    /**
     * 使用面积
     */
    private BigDecimal usableArea;

    /**
     * 位置类型编号
     */
    private String districtShopTypeCode;

    /**
     * 位置类型名称
     */
    private String districtShopTypeName;

    /**
     * 是否需要前置仓 1：是、2：否
     */
    private Integer preStorehouseFlag;

    /**
     * 前置仓主数据编号
     */
    private String preStorehouseMainDataNo;

    /**
     * 无前置仓解决办法
     */
    private String noPreStorehousePlan;

    /**
     * 证照情况: 1-自办照，2-共用资质
     */
    private Integer licenseSituation;

    /**
     * 可营业开始时间
     */
    private String canOpenTimeStart;

    /**
     * 可营业结束时间
     */
    private String canOpenTimeEnd;

    /**
     * 后区是否可加装挂机空调 1：是、2：否
     */
    private Integer airConditioningFlag;

    /**
     * 是否需要设计 1：是、2：否
     */
    private Integer needDesign;

    /**
     * 备注
     */
    private String remark;

    /**
     * 主数据编号
     */
    private String mainDataNo;

    /**
     * 部门id（主数据ID）
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门code（EHR id）
     */
    private String deptCode;

    /**
     * 门店运营名称
     */
    private String shopName;

    /**
     * 门店运营序号
     */
    private String shopNo;

    /**
     * 开发人ID
     */
    private String developerId;

    /**
     * 开发人姓名
     */
    private String developerName;

    /**
     * 开发人电话
     */
    private String developerPhone;

    /**
     * 维护人ID
     */
    private String maintainId;

    /**
     * 维护人姓名
     */
    private String maintainName;

    /**
     * 维护人电话
     */
    private String maintainPhone;

    /**
     * 拓展区域
     */
    private String expandArea;

    /**
     * 运营区域
     */
    private String operateArea;

    /**
     * 合伙人编号
     */
    private String partnerCode;

    /**
     * 合伙人
     */
    private String partnerName;

    /**
     * 签约日期
     */
    private LocalDateTime signDate;

    /**
     * 交房日期
     */
    private LocalDateTime handoverDate;

    /**
     * 项目经理ID
     */
    private String pmId;

    /**
     * 项目经理姓名
     */
    private String pmName;

    /**
     * 项目经理电话
     */
    private String pmPhone;

    /**
     * 工程经理ID
     */
    private String emId;

    /**
     * 工程经理姓名
     */
    private String emName;

    /**
     * 工程经理电话
     */
    private String emPhone;

    /**
     * 退回时间
     */
    private LocalDateTime sendBackTime;

    /**
     * 退回原因
     */
    private String sendBackReason;

    /**
     * 创建人ID
     */
    private Long createrId;

    /**
     * 创建人
     */
    private String createrName;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改人ID
     */
    private Long modiferId;

    /**
     * 修改人
     */
    private String modiferName;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 是已删除 1：是、2：否
     */
    private Integer deleteFlag;

    /**
     * 主数据城市ID
     */
    private String mainCityId;

    /**
     * 运营城市ID
     */
    private String shopCityId;

    /**
     * 提前启动审核结果 1：是、2：否
     */
    private Integer reviewStatus;

    /**
     * 提前启动审核结果
     */
    private String reviewAdvice;

    /**
     * 门店初始名称
     */
    private String shopInitName;

    /**
     * 选址纬度
     */
    private String lat;

    /**
     * 选址经度
     */
    private String lon;

    /**
     * 楼层
     */
    private String floor;

    /**
     * 场地面积（cm2）
     */
    private BigDecimal siteArea;

    /**
     * 长（cm）
     */
    private BigDecimal length;

    /**
     * 宽（cm）
     */
    private BigDecimal width;

    /**
     * 细化场景ID
     */
    private Long detailSceneId;

    /**
     * 细化场景名称
     */
    private String detailSceneName;

    /**
     * 是否需要制冰机 1：是、2：否
     */
    private Integer needIceMakerFlag;

    /**
     * 允许补货时段,json
     */
    private String allowReplenishTime;

    /**
     * 是否需要施工1：是、2：否
     */
    private Integer needConstructionFlag;

    /**
     * 物业联系方式
     */
    private String propertyTel;

    /**
     * 高（cm）
     */
    private BigDecimal height;

    /**
     * 联系人属性
     */
    private String contactAttr;


}
