package com.lucky.domain.partner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 收款订单表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_order")
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单模板编号
     */
    private String templateNo;

    /**
     * 水质质量优|差
     */
    private Integer waterQualityType;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 实付金额
     */
    private BigDecimal actuallyPaid;

    /**
     * 支付方式
     */
    private Integer payMethod;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 创建人
     */
    private String createUser;

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
     * 三方流水号
     */
    private String thirdOrderNo;

    /**
     * 门店序号
     */
    private String shopNcCode;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 合伙人手机号码
     */
    private String applyPhone;

    /**
     * 清单版本号
     */
    private String listingVersion;

    /**
     * 员工编号
     */
    private String empNo;

    /**
     * 业务分类，参考枚举BusinessCategoryEnum枚举
     */
    private Integer businessCategory;

    /**
     * 支付项目，参考枚举PayItemEnum枚举
     */
    private Integer payItem;

    /**
     * 子类，参考枚举SubClassEnum枚举
     */
    private Integer subCategory;

    /**
     * 订单来源
     */
    private Integer source;

    /**
     * 合伙人编号
     */
    private String partnerNo;

    /**
     * 顾问ID
     */
    private Integer advisorId;

    /**
     * 顾问名称
     */
    private String advisorName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 已经退款金额
     */
    private BigDecimal refundMoney;

    /**
     * 运费金额
     */
    private BigDecimal logisticsMoney;

    /**
     * 待收款金额
     */
    private BigDecimal receivableMoney;

    /**
     * 预约到货开始日期
     */
    private LocalDateTime scheduledArrivalTimeBegin;

    /**
     * 预约到货结束日期
     */
    private LocalDateTime scheduledArrivalTimeEnd;

    /**
     * 预约安装开始日期
     */
    private LocalDateTime scheduledInstallTimeBegin;

    /**
     * 预约安装结束日期
     */
    private LocalDateTime scheduledInstallTimeEnd;

    /**
     * 暂存人
     */
    private String temporaryStorageUser;

    /**
     * 暂存时间
     */
    private LocalDateTime temporaryStorageTime;

    /**
     * 意向编号
     */
    private String applyNo;

    /**
     * 退款状态 RefundMoneyEnum
     */
    private Integer refundStatus;

    /**
     * 冻结金额
     */
    private BigDecimal refundFrozen;

    /**
     * 支付超期天数配置
     */
    private Integer payDelayNoticeDay;


}
