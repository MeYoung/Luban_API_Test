package com.lucky.domain.partner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 合伙人门店
 *
 * @author liping.li
 */

@Data
@Table(name ="t_partner_shops")
public class TPartnerShops implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合伙人编号
     */
    private String partnerNo;

    /**
     * 合伙人姓名
     */
    private String partnerName;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 新建人
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifierName;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 区域id
     */
    private Integer districtId;

    /**
     * 区域名
     */
    private String districtName;

    /**
     * 门店编号
     */
    private String shopNo;

    /**
     * 门店状态，参考枚举PartnerShopStatusEnum
     */
    private Integer shopStatus;

    /**
     * 开业时间
     */
    private LocalDateTime openingTime;

    /**
     * 完善状态，参考枚举PartnerShopPerfectStatusEnum
     */
    private Integer perfectStatus;

    /**
     * 完善时间
     */
    private LocalDateTime perfectTime;

    /**
     * 品牌编码
     */
    private String trademarkCode;

    /**
     * 品牌名称
     */
    private String trademarkName;

    /**
     * 运营模式编码
     */
    private String cooperationPatternCode;

    /**
     * 运营模式名称
     */
    private String cooperationPatternName;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 审批时间
     */
    private LocalDateTime approvalTime;

    /**
     * 审批人
     */
    private String approvalName;

    /**
     * 开业状态,参考枚举OpeningStatusEnum
     */
    private Integer openingStatus;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 门店序号
     */
    private String shopNcCode;

    /**
     * 门店类型编号
     */
    private String shopTypeCode;

    /**
     * 门店类型名称
     */
    private String shopTypeName;

    /**
     * 门店级别ID
     */
    private String shopLevelId;

    /**
     * 门店级别名称
     */
    private String shopLevelName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 位置类型编号
     */
    private String districtShopTypeCode;

    /**
     * 位置类型名称
     */
    private String districtShopTypeName;

    /**
     * 建筑面积
     */
    private BigDecimal floorArea;

    /**
     * 使用面积
     */
    private BigDecimal usableArea;

    /**
     * 后区是否加装空调
     */
    private Integer airConditionFlag;

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
     * 门店负责人
     */
    private String principalName;

    /**
     * 门店负责人电话
     */
    private String principalPhone;

    /**
     * 门店负责人邮箱
     */
    private String principalEmail;

    /**
     * 附件url，多个用，号拼接
     */
    private String fileUrls;

    /**
     * 附件名称，多个用，号拼接
     */
    private String fileNames;

    /**
     * 流程状态: 1.待完善；10.已新建；20.已房租合同审批通过；21.已房租合同审批退回；30.已启动；40.已出报审图；41.已物业审批退回；50.已上传装修合同；60.已交付运营；70.已运营确认；71.已运营退回；72.已发起重新装修
     */
    private Integer processStatus;

    /**
     * 进度更新时间
     */
    private LocalDateTime processTime;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 是否需要设计图
     */
    private Integer designDrawingFlag;

    /**
     * 水质参考枚举WaterQualityEnum
     */
    private Integer waterQualityType;

    /**
     * 选址编号
     */
    private String selectionNo;

    /**
     * 选址进度
     */
    private Integer selectionStatus;

    /**
     * 意向项目编号
     */
    private String applyProjectNo;

    /**
     * 房产证附件路径
     */
    private String houseCertificateUrl;

    /**
     * 房产证附件名称
     */
    private String houseCertificateName;

    /**
     * 租房协议附件路径
     */
    private String rentHouseCertificateUrl;

    /**
     * 租房协议附件名称
     */
    private String rentHouseCertificateName;

    /**
     * 租房协议开始时间
     */
    private LocalDateTime rentHouseBeginTime;

    /**
     * 租房协议结束时间
     */
    private LocalDateTime rentHouseEndTime;

    /**
     * 房屋交割单附件名称，多个用，号拼接
     */
    private String houseFileNames;

    /**
     * 房屋交割单附件url，多个用，号连接
     */
    private String houseFileUrls;

    /**
     * 筹备进度 ， 参考枚举PreparationProcessEnum
     */
    private Integer preparationProcess;

    /**
     * 营建状态 ， 参考枚举ConstructionStatusEnum
     */
    private Integer constructionStatus;

    /**
     * 租金金额
     */
    private BigDecimal rentMoney;

    /**
     * 租金类型 RentMoneyTypeEnum  1为固定 2为非固定
     */
    private Integer rentMoneyType;

    /**
     * 是否提交固定费用，BooleanEnum 1为是 2为否
     */
    private Integer isSubmitFixed;

    /**
     * 是否提交月度费用，BooleanEnum 1为是 2为否
     */
    private Integer isSubmitMonthly;

    /**
     * 缴费日期（费用类型为月度才有值）
     */
    private LocalDateTime submitMonthlyDate;

    /**
     * 项目经理（取营建）
     */
    private String projectManager;

    /**
     * 门店品牌变更active, 1：有效 ， 2：无效
     */
    private Integer active;


}
