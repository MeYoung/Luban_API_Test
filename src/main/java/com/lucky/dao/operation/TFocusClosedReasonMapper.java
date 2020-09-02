package com.lucky.dao.operation;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.operation.TFocusClosedReason;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yanxue.kang
 */
public interface TFocusClosedReasonMapper extends MyMapperUtils<TFocusClosedReason> {
    @Select("SELECT * FROM t_focus_closed_reason where `status` = 1 order by id desc")
    List<TFocusClosedReason> getFocusClRea();

}
