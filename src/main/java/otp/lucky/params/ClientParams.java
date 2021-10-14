package otp.lucky.params;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shijin.huang on 2019/6/25
 */
public class ClientParams {

    /**
     * 移动端请求参数
     *
     * @param cid cid
     * @param uid uid
     * @param q   q
     * @return 请求参数
     */
    public Map<String, Object> clientParams(String cid, String uid, String sign, String q) {
        Map<String, Object> params = new HashMap<>(10);
        params.put("cid", cid);
        params.put("uid", uid);
        params.put("sign", sign);
        params.put("q", q);

        return params;
    }

    /**
     * 移动端请求参数，不传q
     *
     * @param cid cid
     * @param uid uid
     * @return 请求参数
     */
    public Map<String, Object> clientParams(String cid, String uid, String sign) {
        Map<String, Object> params = new HashMap<>(10);
        params.put("cid", cid);
        params.put("uid", uid);
        params.put("sign", sign);
        return params;
    }


}
