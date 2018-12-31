一、项目访问路径：1、localhost:8080/query/  查询数据库样例（访问路径配置见：com.swdeve.springBoot.comtroller.query）
                 2、http://localhost:8080/druid/ 数据库监控系统，用户名：admin  密码：123456（用户名密码配置路径见：com.swdeve.springBoot.config.DruidConf.statViewServlet）

二、springBoot整合JPA(JPA是用来操作数据库的)
    1、引入JPA组件：
         <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-data-jpa</artifactId>
         </dependency>
    2、编写一个实体类（bean）和数据表进行映射，并且配置好映射关系  ---见本项目中的com.swdeve.springBoot.entity.User
    3、编写一个Dao接口来操作实体类对应的数据表（Repository）-----见本项目中的com.swdeve.springBoot.repository.UserRepository.java
    4、基本的配置JpaProperties  -- 见本项目中的application.yml中的jpa配置，如下
        spring:
          jpa:
            hibernate:
              #更新或者创建数据表结构
              ddl-auto:
            #控制台显示SQL
            show-sql: true
    5、通过JPA操作数据库  --- 样例见com.swdeve.springBoot.controller.UserController

