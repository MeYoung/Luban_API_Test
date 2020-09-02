package com.lucky.dao.expansion;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.expansion.TTpProject;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liping.li on 2020-05-14
 *
 * t_tp_project mapper
 */
public interface TTpProjectMapper extends MyMapperUtils<TTpProject> {


    /**
     * 根据意向项目编号查询最新一条选址信息
     * @param applyProjectNo 意向项目编号
     * @return 选址信息
     */
    @Select("select * from t_tp_project where third_purpose = #{applyProjectNo} order by create_time DESC limit 1")
    TTpProject getLatestExpansionByApplyProjectNo(String applyProjectNo);



}
