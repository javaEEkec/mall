package com.myteam.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mzx
 */
@MapperScan("com.myteam.mall.mapper")
@SpringBootApplication
public class MysqlProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(MysqlProviderMain.class, args);
    }
}
