package com.lucky.common.testng.dataprovider;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.lucky.common.annotion.OTPDataProvider;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelDataProvider {

    @DataProvider(name = OTPDataProvider.NAME)
    public Iterator<Object[]> dataJson(Class testClass, ITestNGMethod method, ITestContext c) {
        OTPDataProvider otpDataProvider = DataProviderUtil.getDataProvderAn(testClass, method);
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
