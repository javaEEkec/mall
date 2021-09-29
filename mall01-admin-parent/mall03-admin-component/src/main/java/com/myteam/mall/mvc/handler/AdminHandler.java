package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.Admin;
import com.myteam.mall.service.api.AdminService;
import com.myteam.mall.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    ) {
        Admin admin = adminService.getAdminByAdminAcct(adminAcct, adminPswd);
        // 2.将登录成功返回的admin对象存入Session域
        session.setAttribute(MallConstant.ATTR_NAME_LOGIN_ADMIN, admin);
        return "redirect:/admin/to/main/page.html";
    }

    @RequestMapping("admin/do/logout.html")
    public String doLogout(HttpSession session) {
        // 强制Session失效
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }

    @RequestMapping("admin/get/page.html")
    public String getPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            ModelMap modelMap
    ) {
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        modelMap.addAttribute(MallConstant.ATTR_NAME_PAGE_INFO, pageInfo);
        return "admin-page";
    }


    @ResponseBody
    @RequestMapping("admin/save.json")
    public ResultEntity<String> saveAdmin(Admin admin) {
        adminService.saveAdmin(admin);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("admin/update.json")
    public ResultEntity<String> updateAdmin(Admin admin) {
        adminService.updateAdmin(admin);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("admin/get/admin.json")
    public ResultEntity<Admin> getAdmin(Integer adminId){
        Admin admin = adminService.getAdminById(adminId);
        return ResultEntity.successWithData(admin);
    }


    @ResponseBody
    @RequestMapping("admin/remove/by/admin/id/array.json")
    public ResultEntity<Admin> removeByAdminIdArray(@RequestBody List<Integer> adminIdList){
        adminService.removeAdmin(adminIdList);
        return ResultEntity.successWithoutData();
    }
}
