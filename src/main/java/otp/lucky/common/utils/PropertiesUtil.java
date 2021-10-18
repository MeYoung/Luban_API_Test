package otp.lucky.common.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.setting.Setting;
import lombok.extern.slf4j.Slf4j;
import otp.lucky.params.FinalText;

import java.util.StringJoiner;

/**
 * @Author shijin.huang
 * @Date 2021/10/14
 * Properties 文件读取
 */
@Slf4j
public class PropertiesUtil {


    /**
     * 获取配置文件值
     *
     * @param key
     * @return
     */
    public static String getValue(String key) {
        Setting setting;
//        判断用户是否存在配置文件
        String path = userPropertiesPath();
        if (FileUtil.exist(path)) {
            setting = new Setting(path);
            String value = setting.getStr(key);
            if (!"".equals(value) && value != null) {
                return value;
            }
        }

//        读取默认配置
        ClassPathResource re = new ClassPathResource(FinalText.OTP_PROPERTIES);
        setting = new Setting(re.getPath());
        return setting.getStr(key);
    }

    public static String getValue(String filePath, String key) {
        Setting setting = new Setting(filePath);
        return setting.getStr(key);
    }

    public static String userPropertiesPath() {
        StringJoiner stringJoiner = new StringJoiner(FileUtil.FILE_SEPARATOR);
        stringJoiner.add(System.getProperty("user.dir"))
                .add("src")
                .add("main")
                .add("resources")
                .add(FinalText.OTP_USER_PROPERTIES);
        String propertiesPath = stringJoiner.toString();
        log.info("propertiesPath:{}", propertiesPath);
        return propertiesPath;
    }
}
