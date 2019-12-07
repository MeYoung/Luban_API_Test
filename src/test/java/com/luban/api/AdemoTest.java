package com.luban.api;

import com.luban.client.AdminClient;
import com.luban.domain.TShopInfo;
import com.luban.params.AdminPath;
import com.luban.params.admin.SaveParams;
import com.luban.service.dataservice.TShopInfoService;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author shijin.huang
 * @date 2019-12-07
 * @content
 */
public class AdemoTest extends AdminClient {

    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "demo 例子")
    public void demo() {
//      入参准备
        SaveParams saveParams = new SaveParams();
        saveParams.setAge(30).setName("vidor.huang");
//        post请求已经带有cookies，所以直接传入api路劲和参数便可
        String str = post(AdminPath.SAVE, saveParams);
//       接口通用校验
        assertSuccess(str);
//       更多校验忽略
    }


    @Test(description = "数据库使用demo")
    public void sqlDemo() {
        List<TShopInfo> shopInfos = TShopInfoService.findAll();
        List<TShopInfo> shopInfos2 = TShopInfoService.findBystatus(1);
    }
}
