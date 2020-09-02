package com.lucky.domain.ehr;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 员工登录账号绑定表
 *
 * @author liping.li
 */

@Data
@Table(name = "t_ehr_emp_associated_account")
public class TEhrEmpAssociatedAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录账号
     */
    private String loginId;

    /**
     * 关联的员工编号
     */
    private String empNo;

    /**
     * 登录账号类型 1:登录id(现在的登录id) 2:手机号；3:邮箱;
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 备注
     */
    private String remark;


}
