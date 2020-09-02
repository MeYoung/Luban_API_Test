package com.lucky.dao.ehr;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.ehr.TEhrEmployee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Created by liping.li on 2019/6/20
 */
public interface EhrEmployeeMapper extends MyMapperUtils<TEhrEmployee> {

    /**
     * 查出 t_ehr_employee 表中密码为 Zc123456 并员工类型为type的最新10条数据
     *
     * @param password 加密后的密码
     * @param type 员工类型
     * @return 最新一条入职记录
     */
    @Select("SELECT ee.* FROM t_ehr_employee ee left join t_ehr_emp_identity ei on ei.type=#{type} AND ei.company_id=1 AND ee.id=ei.emp_id WHERE ee.password =#{password}  and ee.status = 1 group by entry_date DESC LIMIT 10")
    List<TEhrEmployee> queryGetLatestEmployee(@Param("type") int type, @Param("password") String password);

    /**
     * 多表测试(暂时未用到)
     *
     * @return 返回城市
     */
    TEhrEmployee findCity();


    /**
     * 返回员工数据权限信息
     *
     * @param empNo 员工编号
     * @return List<TEhrEmployee>
     */


    List<TEhrEmployee> selectEmpAuthDept(String empNo);

}
