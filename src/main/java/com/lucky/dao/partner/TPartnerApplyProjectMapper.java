package com.lucky.dao.partner;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.partner.TPartnerApply;
import com.lucky.domain.partner.TPartnerApplyProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liping.li on 2020-05-06
 * <p>
 * 意向项目相关信息
 */
public interface TPartnerApplyProjectMapper extends MyMapperUtils<TPartnerApplyProject> {


    /**
     * 根据合作伙伴编号查询意向项目信息数量
     *
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息数量
     */
    @Select("select count(*) as count from t_partner_apply_project where partner_no = #{partnerNo}")
    Integer getPartnerApplyProjectNum(String partnerNo);


    /**
     * 根据意向项目编号查询意向项目信息
     *
     * @param applyProjectNo 意向项目编号
     * @return 意向项目信息
     */
    @Select("select * from t_partner_apply_project where apply_project_no = #{applyProjectNo}")
    TPartnerApplyProject getPartnerApplyProjectByApplyProjectNo(String applyProjectNo);



    /**
     * 返回最新一条意向项目信息
     *
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息
     */
    @Select("select * from t_partner_apply_project where partner_no = #{partnerNo} order by create_time DESC LIMIT 1")
    TPartnerApplyProject getLatestPartnerApplyProjectByPartnerNo(String partnerNo);



    /**
     * 返回最新一条未选择品牌的意向项目信息
     *
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息
     */
    @Select("select * from t_partner_apply_project where partner_no = #{partnerNo} AND contract_no is null order by create_time DESC LIMIT 1")
    TPartnerApplyProject getNoSetBrandPartnerApplyProject(String partnerNo);


    /**
     * 返回最新一条有意向协议的意向项目信息
     *
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息
     */
    @Select("select * from t_partner_apply_project where partner_no = #{partnerNo} AND contract_no is not null order by create_time DESC LIMIT 1")
    TPartnerApplyProject getContractPartnerApplyProject(String partnerNo);


    /**
     * 返回未再次确认品牌的意向项目信息
     *
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息
     */
    @Select("select t1.* from t_partner_apply_project t1, t_order t2 where  t2.partner_no = #{partnerNo} and t2.business_category=3 and t2.pay_status = 4 and t1.is_confirm_trademark=2 and t1.contract_no = t2.contract_no order by t1.create_time")
    List<TPartnerApplyProject> getNoConfirmBrandApplyProject(String partnerNo);


    /**
     * 返回未添加任何选址编号的意向项目信息
     *
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息
     */
    @Select("select *  from  t_partner_apply_project t1 where (select count(1) as num from t_partner_shops t2 where t1.apply_project_no = t2.apply_project_no) = 0 and t1.partner_no  = #{partnerNo} and t1.is_confirm_trademark=1 order by t1.create_time DESC")
    List<TPartnerApplyProject> getNoAddExpansionApplyProject(String partnerNo);


    /**
     * 返回选址编号状态为 selectionStatus 的意向项目信息
     * <p>
     * NEW(1,"已新建"),
     * SUBMIT(2,"已提交"),
     * COOP_SUCCESS(3,"合作运营部审核通过"),
     * COOP_FAIL(4,"合作运营部审核驳回"),
     * PROFIT_SUCCESS(5,"收益中心审核通过"),
     * PROFIT_FAIL(6,"收益中心审核驳回"),
     *
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息
     */
    @Select("select *  from  t_partner_apply_project t1, t_partner_shops t2 where t2.selection_status=#{selectionStatus} and t1.apply_project_no = t2.apply_project_no and t1.partner_no  = #{partnerNo} and t1.is_confirm_trademark=1 order by t1.create_time DESC")
    List<TPartnerApplyProject> getNewExpansionApplyProjectByStatus(@Param("partnerNo") String partnerNo, @Param("selectionStatus") Integer selectionStatus);


    /**
     * 根据合作伙伴编号获取最新一条有选址记录的意向项目
     * @param partnerNo 合作伙伴编号
     * @return 意向项目信息
     */
    @Select("select *  from  t_partner_apply_project t1 where (select count(1) as num from t_partner_shops t2 where t1.apply_project_no = t2.apply_project_no) > 0 and t1.partner_no  = #{partnerNo} order by t1.create_time DESC limit 1")
    TPartnerApplyProject getLatestExistExpansionApplyProjectByPartnerNo(String partnerNo);

}
