package com.sgg.JDBC2.connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class duridTest {
    @Test
    public void test1(){
        try{
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            DataSource source = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = source.getConnection();
            System.out.println(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
