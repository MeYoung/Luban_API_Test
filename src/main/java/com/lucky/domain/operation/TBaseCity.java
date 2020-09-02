package com.lucky.domain.operation;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 城市信息
 *
 * @author shijin.huang
 */

@Data
@Table(name ="t_base_city")
public class TBaseCity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 省份id
     */
    private Integer provinceId;

    /**
     * 英文名称
     */
    private String enname;

    /**
     * 城市类型
     */
    private Integer cityLevel;

    /**
     * 创建人
     */
    private String createEmp;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifyEmp;

    /**
     * 备注
     */
    private String remark;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否营运
     */
    private Integer isBusiness;

    private String areaCode;

    /**
     * 经度
     */
    private String longtitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 是否区分城市区域
     */
    private Integer distinguishArea;

    /**
     * MDM主键编码
     */
    private String cityCode;

    /**
     * 完善状态 0 未完善 1 已完善
     */
    private Integer completeStatus;

    /**
     * 有效状态 0 无效 1 有效
     */
    private Integer ncStatus;

    /**
     * 数据类型，0：正常业务数据，1：测试专用
     */
    private Integer dataType;


}
