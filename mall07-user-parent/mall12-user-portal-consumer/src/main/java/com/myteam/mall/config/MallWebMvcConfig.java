package com.myteam.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mzx
 */
@Configuration
public class MallWebMvcConfig implements WebMvcConfigurer {

    /**
     *
     * 类似于spring-mvc配置文件的
     * <mvc:view-controller path="/portal/user/to/reg/page.html" view-name="user-reg"/>
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //浏览器访问的地址
        String urlPath = "/portal/user/to/reg/page";
        //目标试图的名称
        String viewName = "user-register";
        registry.addViewController(urlPath).setViewName(viewName);
        registry.addViewController("/portal/user/to/login/page").setViewName("user-login");
        registry.addViewController("/portal/member/to/center/page").setViewName("user-center");
    }
}
