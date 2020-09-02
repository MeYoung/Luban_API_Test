package com.lucky.dao.operation;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.operation.TFocusStopDispatchReason;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yanxue.kang
 */
public interface TFocusStopDispatchReasonMapper extends MyMapperUtils<TFocusStopDispatchReason> {
    @Select("SELECT * FROM t_focus_stop_dispatch_reason where `status` = 1 order by id desc")
    List<TFocusStopDispatchReason> getFocusClDisRea();

}
