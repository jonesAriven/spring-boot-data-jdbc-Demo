package com.swdeve.springBoot.mapper;

import com.swdeve.springBoot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * 使用注解的方式操作数据库
 */
@Component
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id= #{id}")
    public Department getDepartMentById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")//将插入成功的id会写到dept中
//    @Insert("insert into department (departmentName) values (#{departmentName})")
    //若想使java中department实体类对象的departmentName属性与数据库epartment中department_name字段匹配，则需开启mybatis的驼峰自动装配规则,开启方法参考com.swdeve.springBoot.config.MyBatisConf.configurationCustomizerMybatis
    @Insert("insert into department (department_name) values (#{departmentName})")
    public int addDepartment(Department dept);


    @Delete("delete from department where id = #{id}")
    public int deleteDepartment(Integer id);

    //    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    //若想使java中department实体类对象的departmentName属性与数据库epartment中department_name字段匹配，则需开启mybatis的驼峰自动装配规则
    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDepartment(Department dept);
}
