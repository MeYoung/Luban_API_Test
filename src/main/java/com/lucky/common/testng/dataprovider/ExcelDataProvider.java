package com.lucky.common.testng.dataprovider;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.lucky.common.annotion.OTPDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author shijin.huang
 * @Date 2021/09/26
 */
@Slf4j
public class ExcelDataProvider {

    @DataProvider(name = OTPDataProvider.NAME)
    public Iterator<Object[]> dataJson(Class testClass, ITestContext c, Method testMethod) {
        OTPDataProvider otpDataProvider =testMethod.getAnnotation(OTPDataProvider.class);
        String dataFile = otpDataProvider.dataFile();
        String sheetName = otpDataProvider.sheetName();
        return ExcelDataProvider.getData(dataFile, sheetName);
    }


    public static Iterator<Object[]> getData(String filePath, String sheetName) {
        ExcelReader reader;
        if ("".equals(sheetName)) {
            reader = ExcelUtil.getReader(new File(filePath), 0);
        } else {
            reader = ExcelUtil.getReader(new File(filePath), sheetName);
        }
        List<Map<String, Object>> list = reader.readAll();
        List<Object[]> arrayList = DataProviderUtil.map2Obj(list);
        return arrayList.iterator();
    }

    public static List<Map<String, Object>> readExcel(String filePath) {
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<Map<String, Object>> readAll = reader.readAll();
        return readAll;
    }
}
