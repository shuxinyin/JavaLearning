package com.learn.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: shuxy
 * @date: 2023/3/12
 * @description: c3p0 连接池 demo
 */
public class C3P0_ {
    public static void main(String[] args) throws Exception {
//        testC3P0_01();
        testC3P0_02();
    }

    // 方式1
    public static void testC3P0_01() throws Exception {
        // 创建c3p0连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        //读取相关的属性值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 给数据源  comboPooledDataSource  设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        // 设置 初始化 连接数
        comboPooledDataSource.setInitialPoolSize(10);
        // 设置 最大 连接数
        comboPooledDataSource.setMaxPoolSize(50);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            // 这个方法 就是 从 DataSource 接口取 连接
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 5000次数链接耗时 = " + (end - start));  //C3P0 5000次数链接耗时 = 415

    }

    // 方式2
    // 将c3p0-config.xml 拷贝到 src 目录
    // 该文件制定了 连接数据库 和 连接池 的相关参数
    public static void testC3P0_02() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("my_pool");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            // 这个方法 就是 从 DataSource 接口取 连接
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 5000次数链接耗时 = " + (end - start));  //C3P0 5000次数链接耗时 = 444
    }
}
