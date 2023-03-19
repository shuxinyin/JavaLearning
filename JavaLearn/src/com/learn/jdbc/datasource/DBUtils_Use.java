package com.learn.jdbc.datasource;

import com.learn.jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: shuxy
 * @date: 2023/3/13
 * @description:
 */
public class DBUtils_Use {
    public static void main(String[] args) throws SQLException {
//        testQueryMany();
//        testQuerySingle();
//        testScalar();
        testDML();
    }


    // 使用apache-DBUtils 工具类 + druid 完成对表的crud操作
    // 返回多行的结果
    public static void testQueryMany() throws SQLException {

        // 1. 得到连接 druid
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用 DBUtils 类和接口， 引入DBUtils 相关的jar包
        // 3. 创建 QueryRunner = new QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4. 执行相关方法， 返回 ArrayList 结果集
        String sql = "select * from test01 where id >= ?";

        // queryRunner.query  执行query, 得到resultset 封装到  ArrayList 集合中
        // 1 --> sql中 ？ 赋值
        List<Actor01> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor01.class), 2);
        System.out.println("输出集合的值");

        for (Actor01 actor : list) {
            System.out.println(actor);
        }

        JDBCUtilsByDruid.close(null, null, connection);
    }

    // 返回单行的结果
    public static void testQuerySingle() throws SQLException {

        // 1. 得到连接 druid
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用 DBUtils 类和接口， 引入DBUtils 相关的jar包
        // 3. 创建 QueryRunner = new QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4. 执行相关方法， 返回 ArrayList 结果集
        String sql = "select * from test01 where id = ?";

        // queryRunner.query  执行query, 得到 resultset 封装到  ArrayList 集合中
        // 1 --> sql中 ？ 赋值
        Actor01 actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor01.class), 2);
        System.out.println("输出集合的值");

        System.out.println(actor);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    // 返回单行-单列的结果
    public static void testScalar() throws SQLException {

        // 1. 得到连接 druid
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用 DBUtils 类和接口， 引入DBUtils 相关的jar包
        // 3. 创建 QueryRunner = new QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4. 执行相关方法， 返回 ArrayList 结果集
        String sql = "select name from test01 where id = ?";

        // queryRunner.query  执行query, 得到 resultset 封装到  ArrayList 集合中
        // 1 --> sql中 ？ 赋值
        Object query = queryRunner.query(connection, sql, new ScalarHandler(), 2);
        System.out.println("输出集合的值");

        System.out.println(query);

        JDBCUtilsByDruid.close(null, null, connection);
    }


    // 使用apache-DBUtils 工具类 + druid 完成对表的 dml 操作
    public static void testDML() throws SQLException {

        // 1. 得到连接 druid
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用 DBUtils 类和接口， 引入DBUtils 相关的jar包
        // 3. 创建 QueryRunner = new QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4. 执行相关方法， 返回 ArrayList 结果集
//        String sql = "update test01 set name = ? where id = ?";
//        String sql = "insert into test01 values(null, ?, ?, ?, ?)";
        String sql = "delete from test01 where id =?";

        // queryRunner.query  执行query, 得到 resultset 封装到  ArrayList 集合中
        // 1 --> sql中 ？ 赋值
//        int affectRow = queryRunner.update(connection, sql, "林无极", 1);
//        int affectRow = queryRunner.update(connection, sql, "林无极", "女", "1996-10-01", "139");
        int affectRow = queryRunner.update(connection, sql, 3);
        System.out.println(affectRow > 0 ? "执行成功":"执行没有影响到表");


        JDBCUtilsByDruid.close(null, null, connection);
    }
}


