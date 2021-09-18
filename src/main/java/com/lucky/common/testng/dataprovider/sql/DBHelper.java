package com.lucky.common.testng.dataprovider.sql;

import com.lucky.common.annotion.OTPDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;

@Slf4j
public class DBHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBHelper.class);
    private static final String URL = "jdbc:mysql://{0}/{1}?useSSL=false";
    /**
     * 驱动名称
     */
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    public Connection conn = null;
    public PreparedStatement pst = null;

/*    public DBHelper(DataBaseDTO dataBaseDTO, String database, String sql) {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(MessageFormat.format(URL, dataBaseDTO.getIp(),
                    database), dataBaseDTO.getUsername(), dataBaseDTO.getPassword());
            pst = conn.prepareStatement(sql);
        } catch (Exception e) {
            log.error("DBHelper 创建数据库链接失败",e);
            e.printStackTrace();
        }
    }*/

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            log.error("DBHelper 关闭链接",e);
        }
    }




}
