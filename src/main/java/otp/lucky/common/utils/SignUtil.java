package otp.lucky.common.utils;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author shijin.huang
 * @date 2019-09-24
 * <p>
 * 签名
 */
public class SignUtil {
    public static final String API_KEY = "aid";
    public static final String SIGN_KEY = "sign";
    private static final int BLOCK_LEN = 4;
    private static final int OX_FF = 255;
    private static final int BIT = 8;
    private static final int SIX_TEEM = 16;

    /**
     * 生成签名 sign
     *
     * @param uid
     * @param cid
     * @param qAes   加密后的q 参数
     * @param secKey 加密秘钥
     * @return 签名
     */
    public static String getSignStr(String uid, String cid, String qAes, String secKey) {

        TreeMap<String, String> signMap = new TreeMap<>();
        signMap.put("uid", uid);
        signMap.put("cid", cid);
        signMap.put("q", qAes);

        StringBuilder sb = new StringBuilder();
        Iterator iterator = signMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if ((StringUtils.isNotEmpty( signMap.get(key))) &&
                    (!(SIGN_KEY.equals(key))) && (!(API_KEY.equals(key)))) {
                String value = signMap.get(key);
                sb.append(key).append("=").append(value).append(";");
            }
        }
        String tarSign = sb.substring(0, sb.length() - 1);
        return doMD5Sign(tarSign + secKey);
    }

    public static String doMD5Sign(String targetStr) {
        byte[] md5Result = DigestUtils.md5(targetStr.getBytes(Charsets.UTF_8));
        if (md5Result.length != SIX_TEEM) {
            throw new IllegalArgumentException("MD5加密结果字节数组错误");
        }

        Integer first = Math.abs(bytesToInt(md5Result, 0));
        Integer second = Math.abs(bytesToInt(md5Result, 4));
        Integer third = Math.abs(bytesToInt(md5Result, 8));
        Integer fourth = Math.abs(bytesToInt(md5Result, 12));
        return new StringBuilder().append(first.toString()).append(second.toString()).append(third.toString()).append(fourth.toString()).toString();
    }

    private static int bytesToInt(byte[] src, int offset) {
        int value = (src[offset] & 0xFF) << 24 | (src[(offset + 1)] & 0xFF) << 16 | (src[(offset + 2)] & 0xFF) << 8 | src[(offset + 3)] & 0xFF;

        return value;
    }
}
