package com.lucky.domain.attendanceweb;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author feiyao.zhang
 * @date 2020/4/27
 * @content
 * @Version 1.0
 **/

@Data
@Table ( name ="t_atnd_attendance" )
public class AttendanceRecordPO  implements Serializable {
    private static final long serialVersionUID =  446625272865684356L;

    /**
     * 自增
     */
    @Column(name = "id" )
    private Long id;

    /**
     * 考勤人员工id
     */
    @Column(name = "employee_id" )
    private Long employeeId;

    /**
     * 考勤类型:1|排班考勤 2|会议考勤 3|培训考勤 8|分拣考勤
     */
    @Column(name = "attendance_type" )
    private Integer attendanceType;

    /**
     * 当时所属部门Id
     */
    @Column(name = "dept_id" )
    private Long deptId;

    /**
     * 当时所属部门名称
     */
    @Column(name = "dept_name" )
    private String deptName;

    /**
     * 当时区域名称
     */
    @Column(name = "area_name" )
    private String areaName;

    /**
     * 当时城市名称
     */
    @Column(name = "city_name" )
    private String cityName;

    /**
     * 城市id
     */
    @Column(name = "city_id" )
    private Long cityId;

    /**
     * 当时员工岗位名称
     */
    @Column(name = "post_name" )
    private String postName;

    /**
     * 员工性质 0|全职，1|兼职
     */
    @Column(name = "nature" )
    private Integer nature;

    /**
     * 有效工时
     */
    @Column(name = "valid_work_hours" )
    private Double validWorkHours;

    /**
     * 备注
     */
    @Column(name = "remark" )
    private String remark;

    /**
     * 考勤日期
     */
    @Column(name = "attendance_time" )
    private Date attendanceTime;

    /**
     * 是否删除 0：正常，1：已删除
     */
    @Column(name = "is_delete" )
    private Integer isDelete;

    /**
     * 创建时间
     */
    @Column(name = "create_time" )
    private Date createTime;

    /**
     * 创建人员工id
     */
    @Column(name = "create_emp_id" )
    private Long createEmpId;

    /**
     * 修改时间
     */
    @Column(name = "update_time" )
    private Date updateTime;

    /**
     * 修改人员工id
     */
    @Column(name = "update_emp_id" )
    private Long updateEmpId;

    /**
     * 审核时间
     */
    @Column(name = "confirm_time" )
    private Date confirmTime;

    /**
     * 审核人员工id
     */
    @Column(name = "confirm_emp_id" )
    private Long confirmEmpId;

    /**
     * 考勤状态 ：1 正常考勤、 2 异常考勤
     */
    @Column(name = "attence_status" )
    private Integer attenceStatus;

    /**
     * 考勤二级状态 0|正常 1|迟到/早退、2|旷工、3|漏打卡
     */
    @Column(name = "sub_attence_status" )
    private Integer subAttenceStatus;

    /**
     * 排班门店Id
     */
    @Column(name = "schedule_dept_id" )
    private Long scheduleDeptId;

    /**
     * 岗位id
     */
    @Column(name = "post_id" )
    private Long postId;

    /**
     * 班次工时
     */
    @Column(name = "schedule_work_hours" )
    private Double scheduleWorkHours;

    /**
     * 数据来源 1|系统生成数据 2|变更单(异常补录数据) 3|工时申请单
     */
    @Column(name = "data_source" )
    private Integer dataSource;
}

