package com.swdeve.springBoot.mapper;

import com.swdeve.springBoot.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeMapper {
    //    @Select("select * from Employee where id= #{id}")
    public Employee getEmployeeById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")//将插入成功的id会写到dept中
//    @Insert("insert into Employee (lastName) values (#{lastName})")
    //若想使java中Employee实体类对象的lastName属性与数据库Employee中last_Name字段匹配，则需开启mybatis的驼峰自动装配规则
//    @Insert("insert into Employee (last_Name) values (#{lastName})")
    public int addEmployee(Employee emp);


    //    @Delete("delete from Employee where id = #{id}")
    public int deleteEmployee(Integer id);
}
