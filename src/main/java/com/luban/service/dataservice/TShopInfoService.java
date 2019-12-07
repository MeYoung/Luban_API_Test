package com.luban.service.dataservice;

import com.luban.common.utils.BaseDataUtils;
import com.luban.dao.operation.TShopInfoMapper;
import com.luban.domain.TShopInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shijin.huang
 * @date 2019-12-07
 * @content
 */
public class TShopInfoService {

    /**
     * 查询所有数据
     * @return
     */
    public static List<TShopInfo> findAll() {
//        获取数据库链接 session
        SqlSession sessionOperation = BaseDataUtils.getBaseData().getSessionOperation();
        TShopInfoMapper mapper = sessionOperation.getMapper(TShopInfoMapper.class);
        return mapper.selectAll();

    }

    /**
     * 通过状态查询
     * @param stats
     * @return
     */
    public static List<TShopInfo> findBystatus(Integer stats){
        //        获取数据库链接 session
        SqlSession sessionOperation = BaseDataUtils.getBaseData().getSessionOperation();
        TShopInfoMapper mapper = sessionOperation.getMapper(TShopInfoMapper.class);
        return mapper.getShopStus(stats);
    }
}
