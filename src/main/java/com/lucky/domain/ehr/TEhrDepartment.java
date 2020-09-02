package com.lucky.domain.ehr;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 部门信息表
 *
 * @author shijin.huang
 */

@Data
@Table(name ="t_ehr_department")
public class TEhrDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    /**
     * 部门名称
     */
    private String name;

    /**
     * 上级部门id
     */
    private Integer parentId;

    /**
     * 所属城市id
     */
    private Integer cityId;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 部门级别
     */
    private Integer level;

    /**
     * 部门类型
     */
    private Integer type;

    /**
     * 对外部门类型
     */
    private Integer externalType;

    /**
     * 部门地址
     */
    private String address;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 英文名称
     */
    private String enName;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 工作时间段
     */
    private String workTime;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 区号
     */
    private String areaCode;

    /**
     * 门店号
     */
    private String departmentNo;

    /**
     * 商户号
     */
    private String businessNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门负责人id
     */
    private Integer bossId;

    /**
     * 部门负责人姓名
     */
    private String bossName;

    /**
     * 开业时间
     */
    private String openingTime;

    /**
     * 停业时间
     */
    private String closingTime;

    /**
     * 新建人
     */
    private Long createEmp;

    /**
     * 新建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Long modifyEmp;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门主键
     */
    private String ncDeptId;

    /**
     * 上级部门主键
     */
    private String ncDeptParentId;

    /**
     * 部门编码
     */
    private String ncCode;

    /**
     * 所属组织主键
     */
    private String ncOrgId;

    /**
     * 完善状态 0：未完善，1：已完善
     */
    private Integer completeStatus;

    /**
     * NC状态 0：已删除，1：已启用，2未启用，3已停用，4已撤销 
     */
    private Integer ncStatus;

    /**
     * NC人员主键
     */
    private String ncBossId;


}
