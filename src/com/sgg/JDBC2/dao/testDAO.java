package com.sgg.JDBC2.dao;

import com.sgg.JDBC2.bean.Customer;
import com.sgg.JDBC2.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class testDAO {
    private CustomerDAOImpl cdi = new CustomerDAOImpl();
    @Test
    public void test1(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1982-09-19";
        Connection connection=null;
        try{
            Date dt = df.parse(str);
            connection = JDBCUtils.connection();
            connection.setAutoCommit(false);
            Customer cust = new Customer("邓超","zhegnchao@163.com",new Date(dt.getTime()));
            int result = cdi.insert(connection,cust);
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JDBCUtils.close(connection,null);
        }
    }

    @Test
    public void test2(){
        Connection connection = null;
        try{
            connection = JDBCUtils.c3p0();
            connection.setAutoCommit(false);
            cdi.deleteById(connection,25);
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCUtils.close(connection,null);
        }
    }
    @Test
    public void test3(){
        Connection connection = null;
        try{
            //connection = JDBCUtils.c3p0();
            //connection = JDBCUtils.dbcp();
            connection = JDBCUtils.druid();
            Customer cust = cdi.queryById(connection,8);
            System.out.println(cust);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,null);
        }
    }
    @Test
    public void test4(){
        Connection connection = null;
        try{
            connection = JDBCUtils.connection();
            List<Customer> list = cdi.queryAll(connection);
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,null);
        }
    }
    @Test
    public void test5(){
        Connection connection = null;
        try{
            connection = JDBCUtils.connection();
            Long count = cdi.getCount(connection);
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,null);
        }
    }
    @Test
    public void test6(){
        Connection connection = null;
        try{
            connection = JDBCUtils.connection();
            Date dt = cdi.getMaxBirth(connection);
            System.out.println(dt);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,null);
        }
    }
}
