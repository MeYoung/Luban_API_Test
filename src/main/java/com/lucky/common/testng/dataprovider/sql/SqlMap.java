package com.lucky.common.testng.dataprovider.sql;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SqlMap {
    @Select("${sqlStr}")
    List<Map<String, Object>> getPublicItems(@Param(value = "sqlStr") String sqlStr);
}
