package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Admin;

import java.util.List;

/**
 * @author ljs
 */
public interface AdminService {

    /**
     * 添加管理员
     * @param admin 管理员
     */
    void saveAdmin(Admin admin);

    /**
     * 获得所有管理员
     * @return 所有管理员链表
     */
    List<Admin> getAll();

    /**
     * 管理员登录
     * @param adminAcct 管理员账号
     * @param adminPswd 管理员密码
     * @return admin对象
     */
    Admin getAdminByAdminAcct(String adminAcct, String adminPswd);


    PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);

    void updateAdmin(Admin admin);

    Admin getAdminById(Integer adminId);
}
