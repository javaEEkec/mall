package com.myteam.mall.test;


import com.myteam.mall.entity.Admin;
import com.myteam.mall.mapper.AdminMapper;
import com.myteam.mall.service.api.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringJUnitConfig(locations = {"classpath:spring-persist-tx.xml","classpath:spring-persist-mybatis.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsertAdmin(){
        Admin admin  = new Admin(null,"22305","jessie","123456","user_admin");
        int count = adminMapper.insert(admin);
        System.out.println(count);

    }

    @Test
    public void testTx(){
        Admin admin  = new Admin(null,"22692","ljs","123456","user_admin");
        adminService.saveAdmin(admin);
    }



}
