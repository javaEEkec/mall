package com.myteam.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author ljs
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulMain {

    public static void main(String[] args) {
        SpringApplication.run(ZuulMain.class, args);
    }
}
