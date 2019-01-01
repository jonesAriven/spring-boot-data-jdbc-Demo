一、项目访问路径：1、localhost:8080/query/  查询数据库样例（访问路径配置见：com.swdeve.springBoot.comtroller.query）
                 2、http://localhost:8080/druid/ 数据库监控系统，用户名：admin  密码：123456（用户名密码配置路径见：com.swdeve.springBoot.config.DruidConf.statViewServlet）

二、springBoot整合mybatis（mybatis是用来操作数据库）
    1、pom文件中引入mybatis依赖
          <dependency>
                    <groupId>org.mybatis.spring.boot</groupId>
                    <artifactId>mybatis-spring-boot-starter</artifactId>
                    <version>1.3.1</version>
          </dependency>
    2、mybtis操作数据库有两种方式，注解版和配置文件版
       1）注解版：
            a、新增实体类，与数据库有映射关系的实体类，如本项目中的：com.swdeve.springBoot.bean.Department
            b、新增操作数据库接口，如本项目中的：com.swdeve.springBoot.mapper.DepartmentMapper
            c、执行操作，调用操作数据库的接口方法，如：com.swdeve.springBoot.controller.DepartmentController
       2）配置文件版：
            a、新增实体类，与数据库有映射关系的实体类，如本项目中的：com.swdeve.springBoot.bean.Employee
            b、新增操作数据库接口，如本项目中的：com.swdeve.springBoot.mapper.EmployeeMapper
            c、新增配置文件操作数据库接口的配置文件，如：com.swdeve.springBoot.mapper.DepartmentMapper
            d、新增mybatis的mapper配置文件，在application中的配置：
                mybatis:
                  # 指定全局配置文件位置
                  config-location: classpath:mybatis/mybatis-conf.xml
                  # 指定sql映射文件位置
                  mapper-locations: mybatis/mapper/*.xml
            c、执行操作，调用操作数据库的接口方法，如：com.swdeve.springBoot.controller.EmployeeController

二、springBoot整合JPA(JPA是用来操作数据库)
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

三、springBoot整合druid（druid是一个高级数据源，该数据源可以监控数据库的操作）
    1、pom文件中引入druidjar包
         <dependency>
                    <groupId>com.alibaba</groupId>
                    <artifactId>druid</artifactId>
                    <version>1.1.8</version>
          </dependency>
    2、配置druid数据源，在application中配置如下
        spring:
          datasource:
        #配置durid
            initialSize: 5
            minIdle: 5
            maxActive: 20
            maxWait: 60000
            timeBetweenEvictionRunsMillis: 60000
            minEvictableIdleTimeMillis: 300000
            validationQuery: SELECT 1 FROM DUAL
            testWhileIdle: true
            testOnBorrow: false
            testOnReturn: false
            poolPreparedStatements: true
        #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
            filters: stat,wall,log4j
            maxPoolPreparedStatementPerConnectionSize: 20
            useGlobalDataSourceStat: true
            connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
    3、使druid配置生效，导入drudi数据源，并配置druid监控和webfilter，见本项目中的com.swdeve.springBoot.config.DruidConf