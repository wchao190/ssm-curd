package com.sgg.JDBC2.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

public class C3P0Test {
    @Test
    public void test1() throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:postgresql://localhost/testdb" );
        cpds.setUser("dbuser");
        cpds.setPassword("dbpassword");
    }
    @Test
    public void test2() throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource("testC3P0");
        System.out.println(cpds.getConnection());
    }
}
