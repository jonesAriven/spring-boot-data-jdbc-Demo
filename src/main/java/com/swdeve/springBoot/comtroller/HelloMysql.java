package com.swdeve.springBoot.comtroller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloMysql {

    private Logger logger = LoggerFactory.getLogger(HelloMysql.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    public List<Map<String, Object>> query() {
        logger.info("query--start");
        //mysql和oracle不一样，mysql中没有dual表
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from dual;");
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department;");
        logger.info("查询出的结果集为：" + maps.toString());
        return maps;
    }
}
