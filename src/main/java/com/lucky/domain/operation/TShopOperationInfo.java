package com.lucky.domain.operation;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 门店运营信息表
 *
 * @author yanxue.kang
 */

@Data
@Table(name ="t_shop_operation_info")
public class TShopOperationInfo implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    /**
     * 门店基础表ID
     */
    private Long shopBaseId;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 门店状态
     */
    private String status;

    /**
     * 强制关闭门店, 1 闭店，0 不闭店
     */
    private Integer focusClosed;

    /**
     * 强制停止配送，1 停止配送，0： 可以配送
     */
    private Integer focusStopDispatch;

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
     * 当前配送开始时间
     */
    private String currentDispatchStartTime;

    /**
     * 当前配送结束时间
     */
    private String currentDispatchEndTime;

    /**
     * 是否享受企业优惠:0否,1是
     */
    private Integer enjoyEntPref;

    /**
     * 是否配置提成：1：是，0：否
     */
    private Boolean commission;

    /**
     * 是否自动接单 0:否,1是
     */
    private Integer autoReceipt;

    /**
     * 现制商品自动接单上限
     */
    private Integer autoReceiptUp;

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
     * 是否计划闭店 1:计划闭店，0 不计划闭店
     */
    private Boolean planClose;

    /**
     * 计划闭店开始时间
     */
    private LocalDateTime planCloseStartTime;

    /**
     * 计划闭店结束时间
     */
    private LocalDateTime planCloseEndTime;

    /**
     * 是否支持预约，1：支持，2：不支持
     */
    private Boolean reservation;

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

    /**
     * 值守时间方案ID
     */
    private Long dutyTimePlanId;

    /**
     * 是否显示资质信息，0：不显示，1：显示
     */
    private Boolean showLicence;

    /**
     * 是否支持门店充值 1:支持 2:不支持
     */
    private Integer shopDeposit;

    /**
     * 充值方式 1:扫码充值 2:POS刷卡
     */
    private Integer depositType;

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
     * 强制闭店来源 1:门店 2:后台
     */
    private Integer focusClosedSource;

    /**
     * 强制停止配送来源 1:后台 2:资产系统 3:单屏机终端
     */
    private Integer focusStopDispatchSource;

    /**
     * 1启用，2不启用
     */
    private Integer shopDispatchOpened;

    /**
     * 计划开业停业备注
     */
    private String businessRemark;

    /**
     * 计划开业停业类型：1开业2停业
     */
    private Integer businessActionType;



}
