package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.Admin;
import com.myteam.mall.entity.AdminExample;
import com.myteam.mall.exception.LoginFailedException;
import com.myteam.mall.mapper.AdminMapper;
import com.myteam.mall.service.api.AdminService;
import com.myteam.mall.util.MallUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 添加管理员
     *
     * @param admin 管理员
     */
    @Override
    public void saveAdmin(Admin admin) {

        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    /**
     * 管理员登录
     *
     * @param adminAcct 管理员账号
     * @param adminPswd 管理员密码
     * @return admin对象
     *
     */
    @Override
    public Admin getAdminByAdminAcct(String adminAcct, String adminPswd) {
        // 1.根据登录的账号查询Admin对象
        // ①创建AdminExample对象
        AdminExample adminExample = new AdminExample();
        // ②创建Criteria对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        // ③在Criteria对象中封装查询条件
        criteria.andAdminAcctEqualTo(adminAcct);
        // ④调用AdminMapper的方法执行查询
        List<Admin> list = adminMapper.selectByExample(adminExample);
        // 2.判断Admin对象是否为null
        if (list == null || list.size() == 0){
            throw new LoginFailedException(MallConstant.MESSAGE_LOGIN_FAILED);
        }
        if (list.size() > 1){
            throw new RuntimeException(MallConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }
        Admin admin = list.get(0);
        // 3.如果Admin对象是为null则抛出异常
        if (admin == null){
            throw new LoginFailedException(MallConstant.MESSAGE_LOGIN_FAILED);
        }
        // 4.如果Admin对象不为null则将数据库密码从Admin对象中取出
        String userPswdDb = admin.getAdminPswd();
        // 5.将表单提交的明文密码进行加密
        String userPswdFrom = MallUtil.md5(adminPswd);
        // 6.对密码进行比较
        if (!Objects.equals(userPswdDb,userPswdFrom)){
            // 7.如果不一致就抛出异常
            throw new LoginFailedException(MallConstant.MESSAGE_LOGIN_FAILED);
        }
        // 8. 如果一致就返回Admin对象
        return admin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> adminList = adminMapper.selectAdminByKeyWord(keyword);
        return new PageInfo<>(adminList);
    }
}
