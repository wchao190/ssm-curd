package com.sgg.JDBC2.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    // 链接数据库
    public static Connection connection(){
        try{
            InputStream fis = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(fis);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driverClass");
            Class.forName(driver);
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //关闭更新资源
    public static void close(Connection connection, PreparedStatement ps){
        try {
            if(connection != null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps != null)
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //关闭查询资源
    public static void close(Connection connection, PreparedStatement ps,ResultSet rs){
        try {
            if(connection != null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps != null)
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs != null)
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // c3p0连接
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("testC3P0");
    public static Connection c3p0(){
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //dbcp连接
    private static DataSource source;
    static{
        try{
            FileInputStream fis = new FileInputStream(new File("src\\dbcp.properties"));
            Properties properties = new Properties();
            properties.load(fis);
            source = BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection dbcp()throws Exception{
        return source.getConnection();
    }
    //druid连接
    private static DataSource source2;
    static{
        try{
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            source2 = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection druid(){
        try {
            return source2.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
