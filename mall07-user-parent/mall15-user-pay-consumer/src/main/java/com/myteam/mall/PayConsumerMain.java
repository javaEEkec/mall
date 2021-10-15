package com.myteam.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ljs
 */
@EnableFeignClients
@SpringBootApplication
public class PayConsumerMain {

    public static void main(String[] args) {
        SpringApplication.run(PayConsumerMain.class,args);
    }
}
