package com.TestCollection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
public class MyMap {  //javabean,实体类
    private int id;
    private String name;
    private int salary ;  //薪水
    private String department;  //部门
    private Date HireTime;   //入职时间

    public MyMap(int id,String name,int salary,String department,String hireTime)  {
        this.id = id;
        this.name=name;
        this.salary = salary;
        this.department = department;
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        try{
            this.HireTime = df.parse(hireTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getSalary(){
        return this.salary;
    }
    public String getDepartment(){
        return this.department;
    }
    public Date getHireTime(){
        return this.HireTime;
    }
}
