package com.lucky.domain.ehr;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 后台人员信息表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_ehr_employee")
public class TEhrEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    /**
     * 员工id
     */
    private String empLoginId;

    /**
     * 员工编号
     */
    private String empNo;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 所属部门id
     */
    private Integer deptId;

    /**
     * 是否离职(0否，1是)
     */
    private Integer isDimission;

    /**
     * 部门范围
     */
    private String deptScope;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 维护人手机
     */
    private String vindicatorMobile;

    /**
     * 维护人电话
     */
    private String vindicatorTel;

    /**
     * 数据权限类型
     */
    private Integer dataAuthType;

    /**
     * 重置密码时间
     */
    private LocalDateTime resetPwdTime;

    /**
     * 密码是否重置标识
     */
    private Integer resetStatus;

    /**
     * 密码重置token
     */
    private String resetPwdToken;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Integer createEmp;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 修改人
     */
    private Integer modifyEmp;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 锁定状态
     */
    private Integer blockStatus;

    /**
     * 城市范围
     */
    private String cityScope;

    /**
     * 员工照片路径
     */
    private String empImgUrl;

    /**
     * 身份类型
     */
    private Integer identityType;

    /**
     * 状态0:无效 1:有效
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * NC人员主键
     */
    private String ncEmpId;

    /**
     * 岗位主键
     */
    private String ncJobId;

    /**
     * 是否值班主管：0否 1 是
     */
    private Boolean isGuardSatrap;

    /**
     * 是否排班：0否 1 是
     */
    private Boolean isSchedule;

    /**
     * 岗位ID，关联自t_ehr_post.id
     */
    private Long postId;

    /**
     * 入职时间
     */
    private LocalDateTime entryDate;


}

