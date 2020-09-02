package com.lucky.domain.ehr;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 人员身份信息表
 *
 * @author shijin.huang
 */

@Data
@Table(name = "t_ehr_emp_identity")
public class TEhrEmpIdentity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long empId;

    /**
     * 员工性质
     */
    private Integer nature;

    /**
     * 主员工类型
     */
    private Integer type;

    /**
     * 其他员工类型
     */
    private String subType;

    /**
     * 1：本公司 ； 2：其它；3：众包商；4：运营合伙人
     */
    private Integer companyId;

    /**
     * 更改说明
     */
    private String remark;

    /**
     * 最后修改密码时间
     */
    private LocalDateTime lastModifyPasswordTime;

    /**
     * 是否全职运力：0否 1是
     */
    private Boolean isFullCapacity;


}
