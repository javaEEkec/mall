package com.myteam.mall.mvc.handler;

import com.myteam.mall.entity.Admin;
import com.myteam.mall.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ljs
 */
@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("test/ssm.html")
    public String testSsm(ModelMap modelMap){
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList",adminList);
        return "target";
    }
}
