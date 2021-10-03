package com.myteam.mall.handler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mzx
 */
@Controller
public class PortalHandler {
    @RequestMapping("/")
    public String showPortalPage(){
        return "portal";
    }
}
