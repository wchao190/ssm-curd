package com.sgg.JDBC2.dao;

import com.sgg.JDBC2.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {
    @Override
    public int insert(Connection connection, Customer cust) {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        return update(connection,sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql = "delete from customers where id = ?";
        update(connection,sql,id);
    }

    @Override
    public void update(Connection connection, Customer cust) {
        String sql = "update customers set name=?,email=?,birth=? where id = ?";
        update(connection,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customer queryById(Connection connection, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        return select(Customer.class,connection,sql,id);
    }

    @Override
    public List<Customer> queryAll(Connection connection) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = selectList(Customer.class,connection,sql);
        return list;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        return selectValue(connection,sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql = "select max(birth) from customers";
        return selectValue(connection,sql);
    }
}
