package com.lucky.params;

import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.joda.time.base.BaseDateTime;

import java.util.Base64;
import java.util.Map;

/**
 * Created by shijin.huang on 2019/7/20
 * <p>
 * 存放登录用户相关信息和公共全局变量
 */
@Data
public class BaseData {

    private BaseData() {
    }

    private static volatile BaseData baseData;

    public static BaseData getBaseData() {
        if (baseData == null) {
            synchronized (BaseData.class) {
                if (baseData == null) {
                    baseData = new BaseData();
                }

            }
        }
        return baseData;
    }

    /**
     * 登录账号
     */
    private String userNameCapi;

    /**
     * api版本
     */
    private String apiVersion;

    /**
     * 环境
     */
    private String env;

    /**
     * uid
     */
    private String uid;
    /**
     * 登录账号
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 平台
     */
    private String platform;

    /**
     * secKey
     */
    private String secKey;

    /**
     * cid
     */
    private String cid;


    private String callerCode;


    /**
     * secKey
     */
//    private String secKeyEmpapi;

    /**
     * cid
     */
    private String cidEmpapi;


    private String callerCodeEmpapi;

    /**
     * api版本
     */
    private String apiVersionEmpapi;


    /**
     * admin 登录账号
     */
    private String adminUserName;
    /**
     * admin 密码
     */
    private String adminPassword;

    /**
     * Admin login cookies
     */
    private Map<String, String> cookies;

    /**
     * 联营系统 baseURL
     */
    private String adminPartnerBaseURL;

    /**
     * 拓展地图 baseURL
     */
    private String adminExpansionBaseURL;

    /**
     * ehr baseURL
     */
    private String adminEhrBaseURL;

    /**
     * 拓展系统 baseURL
     */
    private String adminExpandBaseURL;

    /**
     * admin 登陆 baseURL
     */
    private String adminLoginBaseURL;

    /**
     * base 服务地址
     */
    private String baseURL;

    /**
     * origin
     */
    private String origin;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * lucky_operation 库的SqlSession
     */
    private SqlSession sessionOperation;

    /**
     * lucky_ehr 库的SqlSession
     */
    private SqlSession sessionEhr;

    /**
     * lucky_partner 库的 SqlSession
     */
    private SqlSession sessionPartner;

    /**
     * lucky_attendance 库的SqlSession
     */
    private SqlSession sessionAttendance;

    /**
     * lucky_expansion 库的SqlSession
     * <p>
     * 拓展地图
     */
    private SqlSession sessionExpansion;


    /**
     * lucky_expand 库的SqlSession
     */
    private SqlSession sessionExpand;


    /**
     * 高德地图 key
     */
    private String gdKey;

    /**
     * 员工登录id
     */
    private String empLoginId;

    /**
     * 员工ID
     */
    private Long empId;

    /**
     * 员工编号
     */
    private String empNo;

    /**
     * 员工姓名
     */
    private String name;


    /**
     * 性别
     */
    private Integer sex;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 所属部门id
     */
    private Integer deptId;

    /**
     * 是否离职(0否，1是)
     */
    private Integer isDimission;

    /**
     * 部门范围
     */
    private String deptScope;
    /**
     * 部门名称
     */
    private String deptName;


    /**
     * 岗位id
     */
    private Long postId;


    /**
     * 应用名rpc
     */
    private String appName;
    /**
     * zookeeper 注册中心地址
     */
    private String zkAddress;
    /**
     * 设置版本
     */
    private String version;
    /**
     * 设置组
     */
    private String group;


//   ============== 联营系统相关 ===============

    /**
     * 合作伙伴编号
     */
    private String partnerNo;


    /**
     * 意向编号
     */
    private String applyNo;


//  =============== 合作伙伴 财务相关api ===============

    /**
     * 财务主体id
     */
    private Long financeBodyId;

    /**
     * 真实账号id
     */
    private Long realAccountId;


}
