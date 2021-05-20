package com.sgg.JDBC2.connection;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCPTest {
    @Test
    public void test1(){
        try{
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(new File("src\\com\\"));
            properties.load(fis);
            DataSource bsf = BasicDataSourceFactory.createDataSource(properties);
            Connection connection = bsf.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
