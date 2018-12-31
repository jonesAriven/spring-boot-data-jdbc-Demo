package com.swdeve.springBoot.controller;

import com.swdeve.springBoot.bean.Department;
import com.swdeve.springBoot.mapper.DepartmentMapper;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentMapper departmentMapper;

    /**
     * 插入dept
     * @param dept
     * @return
     */
    @GetMapping("/dept")//浏览器端请求地址：http://localhost:8080/dept?departmentName=aa
    public Department insertDepartment(Department dept){
        logger.info("请求参数为：" + dept.toString());
        departmentMapper.addDepartment(dept);
        logger.info("插入成功的数据为：" + dept.toString());
        return dept;
    }

    /**
     * 通过id查询dept
     * @param id
     * @return
     */
    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id){
        logger.info("入参为：" + id);
        Department dept = departmentMapper.getDepartMentById(id);
        return dept;
    }
}
