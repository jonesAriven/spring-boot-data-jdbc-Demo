package com.swdeve.springBoot.controller;

import com.swdeve.springBoot.bean.Employee;
import com.swdeve.springBoot.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")//浏览器端访问地址为：http://localhost:8080/emp/1
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        logger.info("需要查询的员工id为：" + id);
        Employee emp = employeeMapper.getEmployeeById(id);
        logger.info("查询出来的员工信息为：" + emp.toString());
        return emp;
    }

    @GetMapping("/emp")//浏览器端访问地址为：http://localhost:8080/emp?lastName=lishi&email=1750163946@qq.com&gender=1&dId=2
    public Employee addEmployee(Employee emp) {
        logger.info("添加的员工信息为：" + emp.toString());
        employeeMapper.addEmployee(emp);
        logger.info("添加成功的员工信息为：" + emp.toString());
        return emp;
    }
}
