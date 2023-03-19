package com.learn.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * @author 韩顺平
 * @version 1.0
 * 这是一个工具类，druid pool test demo
 */
public class JDBCUtilsByDruidUse {
    public static void main(String[] args) {
        testDruid01();
    }

    public static void testDruid01() {
        // 1. 得到链接
        Connection connection = null;
        String sql = "select * from test01 where name=?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        // 3 创建PreparedStatement对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            // 给 占位符 赋值
            preparedStatement.setString(1, "周星驰");

            // 执行, 得到结果集
            set = preparedStatement.executeQuery();

            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("birthday");
                String phone = set.getString("phone");

                System.out.println(id + "\t" + id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }
}
