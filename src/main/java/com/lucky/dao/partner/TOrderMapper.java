package com.lucky.dao.partner;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.partner.TOrder;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liping.li on 2020-05-13
 *
 * t_order Mapper
 */
public interface TOrderMapper extends MyMapperUtils<TOrder> {


    /**
     * 通过 contractNo 获取合同信息
     * @param contractNo 合同号
     * @return 合同信息
     */
    @Select("select * from t_order where contract_no = #{contractNo}")
    TOrder getOrderByContractNo(String contractNo);

    /**
     * 通过 意向项目编号 获取订单信息
     * @param applyProjectNo 意向项目编号
     * @return 订单信息
     */
    @Select("select * from t_order, t_contract where t_order.contract_no = t_contract.contract_no and t_contract.apply_project_no = #{applyProjectNo}")
    TOrder getOrderByApplyProjectNo(String applyProjectNo);


}