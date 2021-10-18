package otp.lucky.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.testng.Assert;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Security;

/**
 * @Author shijin.huang
 * @Date 2021/10/18
 *
 * 加解密工具
 */
@Slf4j
public class AESCryptorUtil {

    private static final int KEY_BIT_SIZE = 128;

    private static final Charset CHAR_SET = Charset.forName("utf-8");

    /**
     * AES，简单分组，填充7
     */
    private static final String ALGORITHM = "AES/ECB/PKCS7Padding";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * 加密字符串。
     *
     * @param target 原始字符串
     * @param key    密钥字符串
     * @return 加密结果字符串
     */
    public static String encrypt(String target, String key) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, initKey(key));
            byte[] encryptResult = cipher.doFinal(target.getBytes(CHAR_SET));
            //兼容安卓环境的1.2codec
            String unsafeStr = new String(Base64.encodeBase64(encryptResult, false), CHAR_SET);
            return unsafeStr.replace('+', '-').replace('/', '_');
        } catch (Exception e) {
            log.error("敏感数据加密错误");
            return e.toString();
        }
    }

    /**
     * 解密字符串。
     *
     * @param target 加密结果字符串
     * @param key    密钥字符串
     * @return 原始字符串
     */
    public static String decrypt(String target, String key) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, initKey(key));
            String unsafeStr = target.replace('-', '+').replace('_', '/');
            byte[] decryptResult = cipher.doFinal(Base64.decodeBase64(unsafeStr.getBytes(CHAR_SET)));
            return new String(decryptResult, CHAR_SET);
        } catch (Exception e) {
            log.error("敏感数据解密错误");
            return e.toString();
        }
    }

    /**
     * 生成密钥字节数组，原始密钥字符串不足128位，补填0.
     *
     * @param originalKey
     * @return
     */
    private static SecretKeySpec initKey(String originalKey) {
        byte[] keys = originalKey.getBytes(CHAR_SET);

        byte[] bytes = new byte[KEY_BIT_SIZE / 8];
        for (int i = 0; i < bytes.length; i++) {
            if (keys.length > i) {
                bytes[i] = keys[i];
            } else {
                bytes[i] = 0;
            }
        }
        return new SecretKeySpec(bytes, "AES");
    }


}
