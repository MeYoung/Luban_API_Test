package com.luban.dao.operation;

import com.luban.common.utils.MyMapperUtils;
import com.luban.domain.TShopInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * xiaoyan.gan
 */
public interface TShopInfoMapper extends MyMapperUtils<TShopInfo> {
    // 查询状态为x的所有数据
    @Select("SELECT * FROM t_shop_info WHERE status =(#{stu1})")
    List<TShopInfo> getShopStus(@Param("stu1") Integer stu1);

}
