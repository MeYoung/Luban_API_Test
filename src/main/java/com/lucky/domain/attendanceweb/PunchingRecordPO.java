package com.lucky.domain.attendanceweb;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author feiyao.zhang
 * @date 2020/4/24
 * @content
 * @Version 1.0
 **/

@Data
@Table(name ="t_ehr_oa_emp_attence")
public class PunchingRecordPO {

    @Id
    private Long id;

    /**
     * 员工编号
     */
    private String employee_no;

    /**
     * 考勤时间
     */
    private Date attence_time;

    /**
     * 打卡照片url
     */
    private String attence_photo_url;

    /**
     * 打卡部门ID
     */
    private Long attence_dept_id;

    /**
     * 实际打卡部门ID
     */
    private Long attence_actual_dept_id;

    /**
     * 打卡类型 0|人脸识别 1|异常打卡 2|人工补录 3|人工导入 4|补卡申请
     */
    private Integer attence_type;

    /**
     * 备注
     */
    private Integer remark;

    /**
     * 岗位名称
     */
    private Long post_name;

    /**
     * 岗位类型(OA体系岗位类型,代码使用需要转化)：1全职 2兼职
     */
    private Integer position_type;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 创建人
     */
    private Long create_emp;

    /**
     * 修改时间
     */
    private Date modify_time;

    /**
     * 修改人
     */
    private Long modify_emp;

    /**
     * 状态 0：无效，1有效
     */
    private Integer status;
}
