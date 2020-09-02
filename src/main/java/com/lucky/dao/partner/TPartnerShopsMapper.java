package com.lucky.dao.partner;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.partner.TPartnerShops;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liping.li on 2020-05-14
 * <p>
 * t_partner_shops mapper
 */
public interface TPartnerShopsMapper extends MyMapperUtils<TPartnerShops> {


    /**
     * 根据合作伙伴编号获取最新一条门店信息
     *
     * @param partnerNo
     * @return 门店信息
     */
    @Select("select * from t_partner_shops where partner_no = #{partnerNo} and dept_id is not null order by create_time DESC limit 1")
    TPartnerShops getLatestShopByPartnerNo(String partnerNo);


    /**
     * 获取最新一条选址为收益审核通过且还未保存过完善合同信息的门店信息
     * <p>
     * * * NEW(1,"已新建"),
     * * * SUBMIT(2,"已提交"),
     * * * COOP_SUCCESS(3,"合作运营部审核通过"),
     * * * COOP_FAIL(4,"合作运营部审核驳回"),
     * * * PROFIT_SUCCESS(5,"收益中心审核通过"),
     * * * PROFIT_FAIL(6,"收益中心审核驳回"),
     *
     * @param partnerNo 合作伙伴编号
     * @return 门店信息
     */
    @Select("select * from t_partner_shops where design_drawing_flag is null and selection_status=5 and partner_no = #{partnerNo}  order by create_time DESC limit 1")
    TPartnerShops getNoSavePerfectContactShopInfoByPartnerNo(String partnerNo);


    /**
     * 根据合作伙伴编号获取 还未发起创建合同 且 选址已通过的门店信息
     * process.status = 1 或者 null 都是未完善
     *
     * @param partnerNo 合作伙伴编号
     * @return 门店信息
     */
    @Select("select *  from  t_partner_shops t1 where (select count(1) as num from t_contract t2 where t1.apply_project_no = t2.apply_project_no and t2.business_category=1) = 0 and t1.partner_no  = #{partnerNo} and selection_status = 5 and t1.process_status =1 order by t1.create_time DESC limit 1")
    TPartnerShops getSavePerfectContactShopInfoByPartnerNo1(String partnerNo);


    /**
     * 根据合作伙伴编号获取 还未发起创建合同 且 选址已通过的门店信息
     * process.status = 1 或者 null 都是未完善
     *
     * @param partnerNo 合作伙伴编号
     * @return 门店信息
     */
    @Select("select *  from  t_partner_shops t1 where (select count(1) as num from t_contract t2 where t1.apply_project_no = t2.apply_project_no and t2.business_category=1) = 0 and t1.partner_no  = #{partnerNo} and selection_status = 5 and t1.process_status is null order by t1.create_time DESC limit 1")
    TPartnerShops getSavePerfectContactShopInfoByPartnerNo2(String partnerNo);


    /**
     * 根据合作伙伴编号获取最新一条已解锁完善合同信息的门店信息
     *
     * @param partnerNo 合作伙伴编号
     * @return 门店信息
     */
    @Select("select * from t_partner_shops where selection_status>=5 and partner_no = #{partnerNo} order by create_time DESC limit 1")
    TPartnerShops getPassExpansionShopInfo(String partnerNo);


    /**
     * 根据合作伙伴编号和营建状态获取门店信息
     *
     * @param partnerNo          合作伙伴编号
     * @param constructionStatus 营建状态
     * @return 门店信息
     * <p>
     * <p>
     * TO_COMPLETE(1,"待完善"),
     * NEW_BUILDER(10,"已新建"),
     * PROJECT_SUBMIT(12,"已提交项目"),
     * PROJECT_CONFIRM(20, "已项目确认"),
     * PROJECT_CONFIRM_RETURN(21, "已项目退回"),
     * TO_START(30,"已启动"),
     * TO_START_RETURN(32,"已启动退回"),
     * CAD_OUTPUT(40,"已出报审图"),
     * PROPERTY_RETURN(41,"已物业审批退回"),
     * CAD_OUTPUT_RETURN(42,"已出图退回"),
     * DECORATE_CONTRACT_UPLOAD(50,"已上传装修合同"),
     * CHECKED(51,"已验收"),
     * OPERATION_UP(60,"已交付运营"),
     * OPERATION_DONE(70,"已运营确认"),
     * OPERATION_RETURN(71,"已运营退回"),
     * DECORATE_CONTRACT_RESUME(72,"已发起重新装修");
     */
    @Select("select * from t_partner_shops where partner_no = #{partnerNo} and construction_status = #{constructionStatus} order by create_time DESC limit 1")
    TPartnerShops getPartnerShopByConstructionStatus(@Param("partnerNo") String partnerNo, @Param("constructionStatus") Integer constructionStatus);


}