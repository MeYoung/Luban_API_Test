package com.luban.rpc;

import com.luban.client.RpcClient;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author shijin.huang
 * @date 2020/1/4
 * @content
 */
@Slf4j
public class GetSaleGoodsListTest extends RpcClient {

    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "获取商品列表")
    public void getSaleGoodsList() {
//        入参对象
        XXXDTO xxxdto = new XXXDTO();
        xxxdto.setDeptId(362L);
        xxxdto.setStopStatus(2);
//        获取service
        XXXXSerivice service = xxxxSerivice();
//        RPC 调用发起
        List<SaleGoodsDTO> result = service.getSaleGoodsList(haltSaleGoodsQueryDTO);
    }
}
