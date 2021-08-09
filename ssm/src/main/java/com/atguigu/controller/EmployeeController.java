package com.atguigu.controller;

import com.atguigu.bean.Employee;
import com.atguigu.bean.Msg;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //@RequestMapping("/emps")
    public String getAllEmployee(@RequestParam(value = "index",defaultValue = "1")Integer index, Model model){
        //引入PageHelper分页插件，startPage不是分页查询，在查询之前调用，传入页码，以及每页的大小
        PageHelper.startPage(index,5);
        // 这是一个分页查询
        List<Employee> list= employeeService.getAll(null);
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo<Employee> employeePageInfo = new PageInfo<>(list,5);
        model.addAttribute("pageInfo",employeePageInfo);
        return "list";
    }

    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsJson(@RequestParam(value = "index",defaultValue = "1")Integer index){
        PageHelper.startPage(index,5);
        List<Employee> all = employeeService.getAll(null);
        PageInfo<Employee> pageInfos = new PageInfo<>(all);
        return Msg.success().add("pageInfo",pageInfos);
    }

    //保存员工，REST风格
    @RequestMapping(value = "emp",method= RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee employee){
        employeeService.saveEmployee(employee);
        return Msg.success();
    }
}
