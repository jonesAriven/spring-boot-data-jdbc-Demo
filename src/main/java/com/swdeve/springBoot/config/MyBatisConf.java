package com.swdeve.springBoot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MyBatisConf {

    @Bean
    public ConfigurationCustomizer configurationCustomizerMybatis() {
        return new ConfigurationCustomizer() {

            @Override
            public void customize(Configuration configuration) {
                //定制mybatis的mapper：开启java的对象属性与数据库的字段的驼峰映射，如java bean中对象的属性为departmentName，数据库总的字段可为department_name
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
