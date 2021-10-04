package com.myteam.mall.handler;

import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.entity.vo.UserVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author ljs
 */
@Controller
public class UserHandler {

    @Autowired
    private MySQLRemoteService mysqlRemoteService;

    @RequestMapping("/do/user/register")
    public String register(UserVO userVO, ModelMap modelMap){

        //执行密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPswd(passwordEncoder.encode(userVO.getUserPswd()));

        //执行保存
        UserPO userPO = new UserPO();
        //复制属性
        BeanUtils.copyProperties(userVO,userPO);
        //设置时间
        userPO.setCreateTime(new Date());
        //调用远程方法
        ResultEntity<String> saveUserResultEntity = mysqlRemoteService.saveUser(userPO);

        if (ResultEntity.FAILED.equals(saveUserResultEntity.getResult())){
            modelMap.addAttribute(MallConstant.ATTR_NAME_MESSAGE,saveUserResultEntity.getMessage());
            return "user-register";
        }
        return "user-login";
    }

}
