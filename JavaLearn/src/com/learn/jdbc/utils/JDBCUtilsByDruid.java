package com.learn.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 韩顺平
 * @version 1.0
 * 这是一个工具类，完成 mysql的连接和关闭资源
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在static代码块去初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    //连接数据库, 返回Connection
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    public static void close(ResultSet set, Statement statement, Connection connection) {

        //判断是否为null
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //将编译异常转成运行异常抛出
            throw new RuntimeException(e);
        }

    }

}
