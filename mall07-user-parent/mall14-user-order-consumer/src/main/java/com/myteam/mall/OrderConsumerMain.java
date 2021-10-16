package com.myteam.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mzx
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderConsumerMain {
    public static void main(String[] args) {

        SpringApplication.run(OrderConsumerMain.class, args);
    }
}
