package com.lucky.domain.admin;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 国家信息表
 *
 * @author 
 */

@Data
@Table(name ="t_base_country")
public class TBaseCountry implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 国家编号
     */
    private String countryNo;

    /**
     * 国家区号
     */
    private String countryZone;

    /**
     * 新建人
     */
    private String createEmp;

    /**
     * 新建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifyEmp;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * mdm国家主键
     */
    private String countryCode;

    /**
     * 状态(0:无效,1:有效)
     */
    private Integer status;

    /**
     * 国家的英文名称
     */
    private String enname;


}
