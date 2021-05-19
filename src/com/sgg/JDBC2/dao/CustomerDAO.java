package com.sgg.JDBC2.dao;

import com.sgg.JDBC2.bean.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustomerDAO {
    // 往customer表插入数据
    int insert(Connection connection, Customer cust);
    // 删除指定id的属性
    void deleteById(Connection connection,int id);
    // 修改数据
    void update(Connection connection, Customer cust);
    //查询指定id的数据
    Customer queryById(Connection connection,int id);
    // 查询多条数据
    List<Customer> queryAll(Connection connection);
    // 查询结果总条数
    Long getCount(Connection connection);
    // 查询结果总条数
    Date getMaxBirth(Connection connection);
}
