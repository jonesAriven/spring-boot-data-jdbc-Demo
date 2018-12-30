package com.swdeve.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataJdbcApplicationTests {

    private Logger logger = LoggerFactory.getLogger(SpringBootDataJdbcApplicationTests.class);
    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() {
        logger.info("数据源是：" + dataSource.getClass());
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            logger.info("获取到的连接是：" +conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

