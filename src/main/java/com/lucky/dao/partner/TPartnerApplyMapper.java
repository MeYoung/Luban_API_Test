package com.lucky.dao.partner;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.partner.PartnerApplyInfo;
import com.lucky.domain.partner.TPartnerApply;
import com.lucky.domain.partner.TPartnerInfo;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liping.li on 2020-05-06
 *
 * 合作伙伴相关信息
 */
public interface TPartnerApplyMapper extends MyMapperUtils<PartnerApplyInfo> {


    /**
     * 根据手机号查询合作伙伴相关信息
     * @param phone 手机号
     * @return 合作伙伴相关信息
     */
    @Select("select t1.* from  t_partner_info t1  , t_partner_apply t2 where t1.apply_no =t2.apply_no and t2.apply_phone = #{phone}")
    PartnerApplyInfo getPartnerApplyInfo(String phone);

    /**
     * 根据手机号查询意向客户相关信息
     * @param phone 手机号
     * @return 意向客户相关信息
     */
    @Select("select * from t_partner_apply where apply_phone = #{phone}")
    TPartnerApply getPartnerApplyInfoByPhone(String phone);
}
