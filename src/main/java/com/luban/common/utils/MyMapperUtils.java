package com.luban.common.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * Created by shijin.huang on 2019/5/8
 */
public interface MyMapperUtils<T> extends Mapper<T>, MySqlMapper<T> {
	
}