package com.myteam.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ljs
 */
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class PortalConsumer {
    public static void main(String[] args) {
        SpringApplication.run(PortalConsumer.class,args);
    }
}
