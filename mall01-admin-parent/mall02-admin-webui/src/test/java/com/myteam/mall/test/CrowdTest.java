package com.myteam.mall.test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringJUnitConfig(locations = "classpath:spring-persist-mybatis.xml")
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
