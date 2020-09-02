package com.lucky.dao.partner;

import com.lucky.domain.partner.TCostDefend;
import com.lucky.common.utils.MyMapperUtils;
import org.apache.ibatis.annotations.Select;

/**
 * @author liping.li
 */
public interface TCostDefendMapper extends MyMapperUtils<TCostDefend> {
    /**
     * 根据合同号查询合同相关信息
     * @return 合同相关信息
     */
    @Select("select * from t_cost_defend where apply_project_no = #{projectNo}")
    TCostDefend getCostDefendByProjectNo(String projectNo);

    @Select("select * from t_cost_defend limit 3,1")
    TCostDefend getOne();
}
