package otp.lucky.common.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * Created by shijin.huang on 2019/5/8
 */
public interface MyMapperUtil<T> extends Mapper<T>, MySqlMapper<T> {
	
}