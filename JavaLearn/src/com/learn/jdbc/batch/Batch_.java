package com.learn.jdbc.batch;

import com.learn.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;

/**
 * @author: shuxy
 * @date: 2023/3/12
 * @description:
 */
public class Batch_ {
    public static void main(String[] args) throws SQLException {
//        noBatch();
        batch();
    }

    // 传统方法
    public static void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");

            preparedStatement.executeUpdate();

        }

        JDBCUtils.close(null, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("传统方式耗时 = " + (end - start));  //传统方式耗时 = 5775
    }

    // 批方式方法
    public static void batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");

            // sql语句 加入到 批处理包中
            preparedStatement.addBatch();
            // 当有1000条记录，在批量执行
            if((i + 1) % 1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }

        }

        JDBCUtils.close(null, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("批方式耗时 = " + (end - start));  //批方式耗时 = 91
    }
}
