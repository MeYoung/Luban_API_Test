package com.lucky.common.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author shijin.huang
 * @date 2019-08-26
 * mybatis plus 提供的代码生成器
 * 可以快速生成 Entity、Mapper、Mapper XML 等各个模块的代码
 * <p>
 * 直接run mian函数，输入表名，便可生成
 */
@Slf4j
public class CodeGenerator {

    /**
     * 数据库 URL
     */
    private static final String URL = "jdbc:mysql://10.104.249.47:3306/lucky_partner?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * 数据库驱动
     */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    /**
     * 数据库用户名
     */
    private static final String USERNAME = "dev_test1";
    /**
     * 数据库密码
     */
    private static final String PASSWORD = "dev_test1";
    /**
     * @author 值
     */
    private static final String AUTHOR = "liping.li";
    /**
     * 包的基础路径
     */
    private static final String BASE_PACKAGE_URL = "com.lucky";
    /**
     * xml文件路径
     */
    private static final String XML_PACKAGE_URL = "/src/main/resources/dao/";
    /**
     * xml 文件模板
     */
    private static final String XML_MAPPER_TEMPLATE_PATH = "generator/templates/mapper.xml";
    /**
     * dao 文件模板
     */
    private static final String MAPPER_TEMPLATE_PATH = "generator/templates/mapper.java";
    /**
     * entity 文件模板
     */
    private static final String ENTITY_TEMPLATE_PATH = "generator/templates/entity.java";
    /**
     * service 文件模板
     */
    private static final String SERVICE_TEMPLATE_PATH = "generator/templates/service.java";
    /**
     * serviceImpl 文件模板
     */
    private static final String SERVICE_IMPL_TEMPLATE_PATH = "generator/templates/serviceImpl.java";


    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("config");
        packageConfig.setParent(BASE_PACKAGE_URL);
        generator.setPackageInfo(packageConfig);

        // 配置自定义代码模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("");
        templateConfig.setXml(XML_MAPPER_TEMPLATE_PATH);
        templateConfig.setMapper(MAPPER_TEMPLATE_PATH);
        templateConfig.setEntity(ENTITY_TEMPLATE_PATH);
        templateConfig.setService(SERVICE_TEMPLATE_PATH);
        templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH);
        generator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude("t_config_fee");
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        log.info("请输入：{}", tip);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
