package com.learn.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: shuxy
 * @date: 2023/3/12
 * @description:
 */
public class Druid_ {
    public static void main(String[] args) throws Exception {
        testDruid();

    }

    public static void testDruid() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));

        // 创建 Druid 连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            // 这个方法 就是 从 DataSource 接口取 连接
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("druid 500000次数链接耗时 = " + (end - start));  //druid 500000次数链接耗时 = 484

    }

}
