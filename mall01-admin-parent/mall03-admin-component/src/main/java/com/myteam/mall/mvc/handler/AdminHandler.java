package com.myteam.mall.mvc.handler;

import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.Admin;
import com.myteam.mall.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author ljs
 */
@Controller
public class AdminHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("admin/do/login.html")
    public String doLogin(
            @RequestParam("adminAcct") String adminAcct,
            @RequestParam("adminPswd") String adminPswd,
            HttpSession session
    ){
        Admin admin = adminService.getAdminByAdminAcct(adminAcct, adminPswd);
        // 2.将登录成功返回的admin对象存入Session域
        session.setAttribute(MallConstant.ATTR_NAME_LOGIN_ADMIN, admin);
        return "redirect:/admin/to/main/page.html";
    }

    @RequestMapping("admin/do/logout.html")
    public String doLogout(HttpSession session){
        // 强制Session失效
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }

}
