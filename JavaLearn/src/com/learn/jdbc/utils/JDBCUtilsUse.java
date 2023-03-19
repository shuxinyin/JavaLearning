package com.learn.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class JDBCUtilsUse {
    public static void main(String[] args) {
        JDBCUse jdbcUse = new JDBCUse();
//        jdbcUse.testDML();
        jdbcUse.testSelect();
    }

}

class JDBCUse {
    public void testSelect() {
        // 1. 得到链接
        Connection connection = JDBCUtils.getConnection();

        String sql = "select * from test01 where name=?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        // 3 创建PreparedStatement对象
        try {
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
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }

    public void testDML() {
        // 1. 得到链接
        Connection connection = JDBCUtils.getConnection();

        String sql = "update test01 set name=? where id=?";
        PreparedStatement preparedStatement = null;

        // 3 创建PreparedStatement对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 给 占位符 赋值
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 2);

            // 执行
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}