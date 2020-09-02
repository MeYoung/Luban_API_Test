package com.lucky.params.papi;

/**
 * Created by liping.li on 2020-04-27
 * <p>
 * 合作伙伴 api 路径
 */

public class PapiPath {


    //    public static final String LUBAN_BASE_URL = "http://127.0.0.1:9528";
    public static final String LUBAN_BASE_URL = "http://10.104.130.97:9528";


//  ========================== base 模块 基础接口 ==============================

    /**
     * 登陆
     */
    public static final String LOGIN = "/resource/partnerapi/base/login";

    /**
     * 发送验证码
     */
    public static final String IDENTIFY_CODE_SMS = "/resource/partnerapi/base/identifycodesms";


    /**
     * 手机号登陆
     */
    public static final String MOBILE_LOGIN = "/resource/partnerapi/base/mobilelogin";


    /**
     * 登出
     */
    public static final String LOGOUT = "/resource/partnerapi/base/logout";

    /**
     * 获取省份城市信息
     */
    public final static String ADDRESS = "/resource/empapi/common/cell/address";


// ========================== business 模块 意向接口 =========================


    /**
     * 填写意向申请表
     */
    public static final String INTENTION_APPLICATION = "/resource/partnerapi/business/intentionApplication";


    /**
     * 注册成为合作伙伴
     */
    public static final String ISLTINTENDED = "/resource/partnerapi/business/isItIntended";


    /**
     * 保存注册信息
     */
    public static final String REGISTRATION_INFO = "/resource/partnerapi/business/registrationInfo";


//  -------------------------- 意向阶段 ------------------------------
    /**
     * 新增意向项目
     */
    public static final String ADD_INTENDED_PROJECT = "/resource/partnerapi/business/addIntendedProject";

    /**
     * 意向金查询
     */
    public static final String INTENTION_BILL = "/resource/partnerapi/business/intentionbill";


    /**
     * 获取品牌列表
     */
    public static final String GET_BRAND_LIST = "/resource/partnerapi/business/getBrandList";


    /**
     * 合同签约链接获取
     */
    public static final String SIGN_CONTRACT = "/resource/partnerapi/business/signcontract";


    /**
     * 意向项目明细
     */
    public static final String PROJECT_DETAIL = "/resource/partnerapi/business/projectdetail";

    /**
     * 首页意向项目
     */
    public static final String INTENDED_PROJECTS = "/resource/partnerapi/business/intendedProjects";


    /**
     * 品牌选择接口(确认选择)
     */
    public static final String CHOOSE_BRAND = "/resource/partnerapi/prepare/chooseBrand";

//    -------------------------------- 选址阶段 ---------------------------

    /**
     * 新建暂存选址
     */
    public static final String ADD_EXPANSION_PROJECT = "/resource/empapi/expansion/project";


    /**
     * 查询选址详情
     */
    public static final String EXPANSION_INFO = "/resource/empapi/expansion/info";


    /**
     * 查询选址列表
     */
    public static final String EXPANSION_LIST = "/resource/empapi/expansion/list";


    /**
     * 保存完善合同信息
     */
    public static final String SAVE_PERFECT_CONTRACT = "/resource/partnerapi/business/saveperfectcontract";


    /**
     * 查询完善合同信息
     */
    public static final String QUERY_CONTRACT = "/resource/partnerapi/business/querycontract";


    /**
     * 提交租房合同与产权证明
     */
    public final static String UPLOAD_HOUSE_CERTIFICATION_INFO = "/resource/partnerapi/business/uploadhousecertificateinfo";


    /**
     * 查询租房合同与产权证明
     */
    public final static String GET_HOUSE_CERTIFICATION_INFO = "/resource/partnerapi/business/gethousecertificateinfo";


    /**
     * 查询城市水质报告
     */
    public final static String QUERY_WATER_QUALITY = "/resource/partnerapi/business/querywaterquality";


    //    ==================== 筹备阶段 ======================
    public final static String SAVE_HOUSES_DELIVERY = "/resource/partnerapi/prepare/savehousesdelivery \n";
    public final static String UPLOAD_SHOP_LICENSE = "/resource/partnerapi/business/uploadshoplicense";
    public final static String QUERY_SHOP_LICENSE = "/resource/partnerapi/business/queryshoplicense";
    public final static String SUBMIT_INVESTIGATION = "/resource/luckyconstructionemapi/prepare/submitInvestigation";

    /**
     * 首页门店基本信息
     */
    public static final String ACCOUNT_MANAGEMENT = "/resource/partnerapi/partnership/accountManagement";
    /**
     * 首页门店基本信息
     */
    public static final String ACCOUNT_MANAGEMENT_FOR_FINANCE_ID = "/resource/partnerapi/partnership/accountManagementForFinanceId";
    /**
     * 首页门店列表
     */
    public static final String ACCOUNT_MANAGEMENT_DROP_LIST = "/resource/partnerapi/partnership/accountManagementDropList";
    /**
     * 营业额月、日统计
     */
    public static final String TOTAL_TURNOVER = "/resource/empapi/partnership/totalTurnover";
    /**
     * 营业额每天详情
     */
    public static final String DETAILED_TURNOVER = "/resource/empapi/partnership/detailedTurnover";
    /**
     * 营业额订单详情
     */
    public static final String ORDER_DETAILS = "/resource/partnerapi/partnership/orderDetails";
    /**
     * 每月运营代理费汇总及详情
     * 货物成本每月汇总
     */
    public static final String SETTLEMENT_TOTAL = "/resource/empapi/partnership/settlementTotal";
    /**
     * 货物成本关联的清算单列表
     */
    public static final String TURNOVER_AND_AGENCY_FEES = "/resource/empapi/partnership/turnoverAndAgencyFees";
    /**
     * 配退货详情
     */
    public static final String GET_CLEARING_ITEM_LIST = "/resource/partnerapi/partnership/getClearingItemList";
    /**
     * 提现(这个接口没有调用）
     * 运营代理费详情
     * 客诉赔付结算详情
     * 客诉赔付结算详情
     */
    public static final String SETTLEMENT = "/resource/empapi/partnership/settlement";
    /**
     * 首页提现接口
     */
    public static final String SETTLEMENT_CASH_CARD = "/resource/partnerapi/partnership/cashCard";
    /**
     * 提现记录
     */
    public static final String BILL_DETAILS = "/resource/partnerapi/partnership/billDetails";
    /**
     * 填写开票信息页面
     */
    public static final String TICKED_BASE = "/resource/empapi/partnership/ticketBase";
    /**
     * 获取快递公司
     */
    public static final String COURIER_COMPANY = "/resource/empapi/partnership/courierCompany";
    /**
     * 提交开票
     */
    public static final String SUBMITTING_INVOICE = "/resource/empapi/partnership/submittingInvoice";
    /**
     * 开票记录
     */
    public static final String INVOICE_SUBMISSION_RECORDS = "/resource/empapi/partnership/invoiceSubmissionRecords";
    /**
     * 资金明细类型汇总
     */
    public static final String CAPITAL_DETAILS_TYPE = "/resource/partnerapi/partnership/capitalDetailsType";
    /**
     * 查看资金明细列表
     */
    public static final String GET_TRANSACTION_FLOWING_LIST = "/resource/empapi/partnership/getTransactionFlowingList";
    /**
     * 查看月汇总收入和支出
     */
    public static final String MERGER_OPERATING_AGENT_SINANDOUT = "/resource/partnerapi/partnership/mergeroperatingagentsinandout";
    /**
     * 调账详情
     */
    public static final String ADJUST_ACCOUNT_DETAILS = "/resource/partnerapi/partnership/adjustAccountDetails";
    /**
     * 运营代理费详情
     */
    public static final String MERGER_OF_OPERATING_AGENTS = "/resource/empapi/partnership/mergerofoperatingagents";
    /**
     * 毛利返还详情
     */
    public static final String CUSTOMER_COMPENSATION_LIST = "/resource/partnerapi/partnership/customercompensationlist";
    /**
     * 设备维保费用详情
     */
    public static final String GET_MAINTENCE_SETTLE_DETAIL = "/resource/partnerapi/partnership/getmaintenancesettledetail";
    /**
     * 设备维保费用详情
     */
    public static final String COMPONENT_LIST = "/resource/partnerapi/partnership/componentlist";
    /**
     * 毛利返还详情
     */
    public static final String RETURN_STATEMENT_DETAILS = "/resource/partnerapi/partnership/returnStatementDetails";
    /**
     * 银行卡列表
     */
    public static final String WITHDRAWBLE_CASH = "/resource/partnerapi/partnership/withdrawableCash";
    /**
     * 更换与添加银行卡
     */
    public static final String REPLACEMENT_BANK = "/resource/partnerapi/partnership/replacementbank";
    /**
     * 密码校验
     */
    public static final String CHECK_EMPLOYEE_PASSWORD = "/resource/partnerapi/partnership/checkEmployeePassword";
    /**
     * 开户银行列表
     */
    public static final String OPENING_BANK = "/resource/partnerapi/partnership/openingbank";
    /**
     * 开户支行列表
     */
    public static final String OPENING_BANK_BRANCH = "/resource/partnerapi/partnership/openingbankbranch";

    /**
     * 设置品牌
     */
    public static final String BRAND_SETUP = "/resource/partnerapi/business/brandSetup";


    /**
     * 合同列表读取
     */
    public static final String CONTRACT_LIST = "/resource/partnerapi/business/contractlist";
    /**
     * 固定费用列表
     */
    public static final String LIST_FIXED_FEE_MANAGE = "/resource/partnerapi/business/listFixedFeeManage";

    public static final String GET_ALL_FIXED_FEE_MANAGE = "/resource/partnerapi/business/getAllFixedFeeManage";
    /**
     * 修改费用
     */
    public static final String SUBMIT_FIXED_FEE_MANAGE = "/resource/partnerapi/business/submitFixedFeeManage";

    /**
     * 月度费用列表
     */
    public static final String LIST_MONTHLY_FEE_MANAGE = "/resource/partnerapi/business/listMonthlyFeeManage";
    public static final String GET_ALL_MONTHLY_FEE_MANAGE = "/resource/partnerapi/business/getAllMonthlyFeeManage";
    public static final String SUBMIT_MONTHLY_FEE_MANAGE = "/resource/partnerapi/business/submitMonthlyFeeManage";

    /**
     * 人气商品配置
     */
    public static final String GETHOTCOMMIDITYLIST = "/resource/partnerapi/hotcommidity/list";
    public static final String UPDATEHOTCOMMIDITY = "/resource/partnerapi/hotcommidity/update";

//  ================== 门店考勤 ====================

    /**
     * 合伙人-打卡记录 获取打卡门店列表，包含数据权限下所有部门及近半年有过打卡记录的部门
     */
    public static final String DEPT_CLOCK_LIST = "/resource/partnerapi/emmanage/deptclocklist";

    /**
     * 合伙人-打卡记录 获取出勤类型列表
     */
    public static final String ATTENCE_TYPE_LIST = "/resource/partnerapi/emmanage/attencetypelist";

    /**
     * 合伙人-打卡记录 获取员工打卡记录列表
     */
    public static final String EMON_CLOCK_LIST = "/resource/partnerapi/emmanage/emonclocklist";

}
