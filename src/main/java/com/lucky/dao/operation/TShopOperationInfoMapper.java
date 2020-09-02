package com.lucky.dao.operation;

import com.lucky.common.utils.MyMapperUtils;
import com.lucky.domain.operation.TShopOperationInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * xiaoyan.gan
 */
public interface TShopOperationInfoMapper extends MyMapperUtils<TShopOperationInfo> {
    // 获取门店状态为已开业和待停业的数据
    @Select("SELECT * FROM t_shop_operation_info WHERE status =(#{stu1})")
    List<TShopOperationInfo> getShopStus(@Param("stu1") String stu1);

}
