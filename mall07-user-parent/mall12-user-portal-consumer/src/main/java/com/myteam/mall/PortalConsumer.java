package com.myteam.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ljs
 */
@SpringBootApplication
@EnableEurekaClient
public class PortalConsumer {
    public static void main(String[] args) {
        SpringApplication.run(PortalConsumer.class,args);
    }
}
