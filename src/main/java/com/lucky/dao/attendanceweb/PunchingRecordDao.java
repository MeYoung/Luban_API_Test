package com.lucky.dao.attendanceweb;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.attendanceweb.PunchingRecordPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


public interface PunchingRecordDao extends MyMapperUtils<PunchingRecordPO> {
    /**
     * 根据开始时间和结束时间查询有效打卡
     *
     * @Param startTime 开始时间
     * @Param endTime 结束时间
     * @Param employeeNo 员工编号
     * @return List<PunchingRecordPO> 列表
     */
    @Select("SELECT * FROM `t_ehr_oa_emp_attence` where status = 1 and attence_time >= #{startTime} and attence_time <= #{endTime} and employee_no = #{employeeNo}")
    List<PunchingRecordPO> queryPunchingRecord(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("employeeNo") String employeeNo);

    /**
     * 根据员工编号查询有打卡的日期
     *
     * @param employeeNo 员工编号
     * @return attendanceDate 考勤日期
     */
    @Select("select attence_time as attendanceTime from t_ehr_oa_emp_attence where status = 1 and employee_No = #{employeeNo} LIMIT 1")
    Date attendanceDate(@Param("employeeNo") String employeeNo);

    PunchingRecordPO getPunchingRecordByEmpNo();
}
