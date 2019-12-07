package com.luban.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by shijin.huang on 2019/6/22
 * <p>
 * 读取配置文件
 */
@Slf4j
public class EnvReaderUtils {

    String filePath = "";
    static String path = System.getProperty("user.dir");

    public EnvReaderUtils(String fileName) {
        String filePath = path + "/src/main/resources/env/" + fileName;
        this.filePath = filePath;
    }

    /**
     * 根据 关键获取配置文件
     *
     * @param key 关键字
     * @return
     */
    public String getValue(String key) {
        Properties properties = getConfig();
        return properties.getProperty(key);

    }


    /**
     * 获取配置文件
     *
     * @return
     */
    private Properties getConfig() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            properties = null;
            log.warn("FileNotFoundException:" + filePath);
        } catch (IOException e) {
            properties = null;
            log.warn("IOException:" + filePath);
        }
        return properties;
    }

}
