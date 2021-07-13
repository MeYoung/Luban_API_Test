package com.lucky.common.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.common.report.TestStep;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.util.Map;

@Activate(group = {CommonConstants.CONSUMER})
@Slf4j
public class DubboReportFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String name = invoker.getInterface().getName();
        Object[] args = invocation.getArguments();
        String method = invocation.getMethodName();
        String prefix = "调用服务：" + name + "." + method;
        Result result = invoker.invoke(invocation);
        Map<String, String> map = invocation.getAttachments();
        String version = "/version: " + map.get("version");
        String group = "/group: " + map.get("group");
        String request = TestStep.rpcRequestStep(prefix + version + group, JSONArray.toJSONString(args));
        String response = TestStep.respondStep(JSONObject.toJSONString(result.getValue()));
        log.info("RPC请求参数： {}", request);
        log.info("PRC请求结果： {}", response);
        return result;
    }

}
