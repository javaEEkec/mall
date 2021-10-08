package com.myteam.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ljs
 */
@EnableFeignClients
@SpringBootApplication
public class ProductConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(ProductConsumerMain.class,args);
    }
}
