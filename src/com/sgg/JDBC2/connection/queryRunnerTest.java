package com.sgg.JDBC2.connection;

import com.sgg.JDBC2.bean.Customer;
import com.sgg.JDBC2.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class queryRunnerTest {
    @Test
    public void test1(){
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.druid();
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        try {
            runner.update(connection,sql,"张坤","zkun@yifangda.com","1981-08-11");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.c3p0();
        String sql = "select id,name,email,birth from  customers where name = ?";
        BeanHandler<Customer> handler = new BeanHandler<Customer>(Customer.class);
        try {
            Customer result = runner.query(connection,sql,handler,"汪峰");
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.c3p0();
        String sql = "select id,name,email,birth from  customers where id < ?";
        BeanListHandler<Customer> handler = new BeanListHandler<Customer>(Customer.class);
        try {
            List<Customer> query = runner.query(connection, sql, handler, 3);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test4(){
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.c3p0();
        String sql = "select id,name,email,birth from  customers where id < ?";
        MapListHandler handler = new MapListHandler();
        try {
            List<Map<String, Object>> query = runner.query(connection, sql, handler, 3);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test5(){
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.c3p0();
        String sql = "select max(birth) from  customers";
        ScalarHandler handler = new ScalarHandler();
        try {
            Object query = runner.query(connection, sql, handler);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test6(){
        Connection connection=null;
        QueryRunner runner = new QueryRunner();
        try{
            connection = JDBCUtils.connection();
            connection.setAutoCommit(false);
            String sql1 = "UPDATE user_table SET balance=1200 WHERE USER=?";
            String name1 = "BB";
            runner.update(connection,sql1,name1);
            //模拟异常
            System.out.println(10/0);
            String sql2 = "UPDATE user_table SET balance=800 WHERE USER=?";
            String name2 = "AA";
            runner.update(connection,sql2,name2);
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
