package com.lucky.dao.partner;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.partner.TContract;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liping.li on 2020-05-06
 *
 * 合同相关信息
 */
public interface TContractMapper extends MyMapperUtils<TContract> {


    /**
     * 根据合同号查询合同相关信息
     * @param contractNo 合同号
     * @return 合同相关信息
     */
    @Select("select * from t_contract where contract_no = #{contractNo}")
    TContract getContractByContractNo(String contractNo);

    /**
     * 根据用户名和合同状态获取最新一条意向协议签订的记录
     * @param userName 用户名
     * @return 合同记录
     */
    @Select("select * from t_contract where create_user = #{userName} and contract_status=#{contractStatus} and apply_project_no is not null order by create_time DESC limit 1")
    TContract getIntentionAgreementByUserName(@Param("userName") String userName, @Param("contractStatus") int contractStatus );

}
