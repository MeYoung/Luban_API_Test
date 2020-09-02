package com.lucky.dao.ehr;

import com.lucky.domain.ehr.TEhrEmpAssociatedAccount;
import com.lucky.common.utils.MyMapperUtils;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liping.li
 * <p>
 * ehr 临时账号
 */
public interface TEhrEmpAssociatedAccountMapper extends MyMapperUtils<TEhrEmpAssociatedAccount> {


    /**
     * 获取联营最新的临时账号
     *
     * @return
     */
    @Select("select * from t_ehr_emp_associated_account where type = 2 and emp_no like \"OP%\" order by create_time DESC limit 5")
    List<TEhrEmpAssociatedAccount> getTempAccountList();

}
