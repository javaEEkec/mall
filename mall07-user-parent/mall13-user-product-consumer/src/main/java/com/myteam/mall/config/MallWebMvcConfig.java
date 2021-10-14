package com.myteam.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ljs
 */
@Configuration
public class MallWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/to/page").setViewName("product-page");
        registry.addViewController("/to/apply/for/product/agency").setViewName("product-agency-apply");
    }
}
