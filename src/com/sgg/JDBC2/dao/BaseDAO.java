package com.sgg.JDBC2.dao;

import com.sgg.JDBC2.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class BaseDAO<T>{
    private Class<T> type;
    public BaseDAO(){
        Class clazz = this.getClass();
        System.out.println("当前运行类："+clazz);
        Type type = clazz.getGenericSuperclass();
        System.out.println("type-->"+type);
        ParameterizedType parameterizedType = (ParameterizedType)type;
        System.out.println("parameterizedType-->"+parameterizedType);
        Type[] actualTypeArgument = parameterizedType.getActualTypeArguments();
        for(int i=0;i<actualTypeArgument.length;i++){
            System.out.println("actualTypeArgument-->"+actualTypeArgument[i]);
        }
        this.type = (Class<T>)actualTypeArgument[0];
    }
    // 更新数据
    public int update(Connection connection,String sql,Object...args){
        PreparedStatement ps=null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps);
        }
        return 0;
    }

    // 查询多条数据
    public <T> ArrayList<T> selectList(Class<T> clazz,Connection connection,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            // 执行查询，返回结果集
            resultSet = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData rsm = resultSet.getMetaData();
            // 获取结果集的列数
            int colNum = rsm.getColumnCount();
            ArrayList<T> list = new ArrayList<T>();
            while(resultSet.next()){
                T t = clazz.newInstance();
                //for循环结果集的每一列数据
                for(int i=0;i<colNum;i++){
                    // 获取列名
                    String colName = rsm.getColumnLabel(i+1);
                    // 获取列值
                    Object colValue = resultSet.getObject(colName);
                    //利用反射获取javabean属性
                    Field field = clazz.getDeclaredField(colName);
                    field.setAccessible(true);
                    field.set(t,colValue);
                }
                list.add(t);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps,resultSet);
        }
        return null;
    }

    // 查询单条数据
    public <T> T select(Class<T> clazz,Connection connection,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            // 执行查询，返回结果集
            resultSet = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData rsm = resultSet.getMetaData();
            // 获取结果集的列数
            int colNum = rsm.getColumnCount();
            if(resultSet.next()){
                T t = clazz.newInstance();
                //for循环结果集的每一列数据
                for(int i=0;i<colNum;i++){
                    // 获取列名
                    String colName = rsm.getColumnLabel(i+1);
                    // 获取列值
                    Object colValue = resultSet.getObject(colName);
                    //利用反射获取javabean属性
                    Field field = clazz.getDeclaredField(colName);
                    field.setAccessible(true);
                    field.set(t,colValue);
                }
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps,resultSet);
        }
        return null;
    }
    //查询单个字段值
    public <E>E selectValue(Connection connection,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                return (E)resultSet.getObject(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps,resultSet);
        }
        return null;
    }
}
