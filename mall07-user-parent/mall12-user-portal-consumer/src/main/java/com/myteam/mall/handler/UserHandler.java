package com.myteam.mall.handler;

import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.entity.vo.UserLoginVO;
import com.myteam.mall.entity.vo.UserVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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

        //执行密码加密：SpringSecurity加密算法SHA-256+随机盐+密钥对密码进行加密
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
        return "redirect:/portal/user/to/login/page";
    }

    @RequestMapping("/portal/user/do/login")
    public String doLogin(@RequestParam("userAcct") String userAcct, @RequestParam("userPswd") String userPswd,
                          ModelMap modelMap, HttpSession session){
        // 调用远程接口查询登录账号
        ResultEntity<UserPO> resultEntity = mysqlRemoteService.getUserPOByUserAcctRemote(userAcct);

        // 失败则返回登录页面
        if (ResultEntity.FAILED.equals(resultEntity.getResult())){
            modelMap.addAttribute(MallConstant.ATTR_NAME_EXCEPTION,resultEntity.getMessage());
            return "user-login";
        }

        UserPO userPO = resultEntity.getData();

        if (userPO == null){
            modelMap.addAttribute(MallConstant.ATTR_NAME_EXCEPTION,MallConstant.MESSAGE_LOGIN_FAILED);
            return "user-login";
        }

        //比较密码
        //数据库查到的密码
        String userPswdDataBase = userPO.getUserPswd();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // matches方法判断原文密码与加密密码是否匹配，因为加密算法盐值是随机的，每一次对相同原文加密生成的密文都是不同的，所以不能用==或equals判断密码是否正确
        boolean matchesResult = passwordEncoder.matches(userPswd, userPswdDataBase);
        // 如果密码不匹配，则
        if (!matchesResult){
            modelMap.addAttribute(MallConstant.ATTR_NAME_EXCEPTION,MallConstant.MESSAGE_LOGIN_FAILED);
        }

        //创建UserLoginVO对象存入session域
        UserLoginVO userLoginVO = new UserLoginVO(userPO.getUserId(), userPO.getUserName(), userPO.getEmail());
        session.setAttribute(MallConstant.ATTR_NAME_LOGIN_USER,userLoginVO);

        return "redirect:http://www.mall.com/portal/member/to/center/page";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/portal/user/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }

}
