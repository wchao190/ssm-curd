package com.atguigu.service;

import com.atguigu.bean.Department;
import com.atguigu.bean.DepartmentExample;
import com.atguigu.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getDepts(DepartmentExample example){

        return departmentMapper.selectByExample(example);
    }

}
