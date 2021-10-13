package com.myteam.mall.handler;

import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.po.Shop;
import com.myteam.mall.entity.po.ShopCheck;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author mzx
 */
@Controller
public class ShopHandler {

    @Autowired
    private MySQLRemoteService mysqlRemoteService;

    @RequestMapping("/do/shop/register")
    public String doShopRegister(ShopCheck shopCheck, ModelMap modelMap){
        shopCheck.setShopCheckStatus("待审核");
        //执行密码加密：SpringSecurity加密算法SHA-256+随机盐+密钥对密码进行加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        shopCheck.setShopPwd(passwordEncoder.encode(shopCheck.getShopPwd()));

        //将信息提交给后台管理系统审核
        ResultEntity<String> resultEntity = mysqlRemoteService.saveShopCheck(shopCheck);

        if (ResultEntity.FAILED.equals(resultEntity.getResult())){
            modelMap.addAttribute(MallConstant.ATTR_NAME_MESSAGE,resultEntity.getMessage());
            return "shop-register";
        }

        return "redirect:http://www.mall.com/portal/shop/to/login/page";

    }

    @RequestMapping("/do/shop/login")
    public String doShopLogin(@RequestParam("shopAcct") String shopAcct, @RequestParam("shopPwd") String shopPswd,
                              ModelMap modelMap, HttpSession session){
        ResultEntity<Shop> resultEntity = mysqlRemoteService.getShopByShopAcctRemote(shopAcct);
        if (ResultEntity.FAILED.equals(resultEntity.getResult())){
            modelMap.addAttribute(MallConstant.ATTR_NAME_EXCEPTION,resultEntity.getMessage());
            return "shop-login";
        }

        Shop shop = resultEntity.getData();
        System.out.println(shop);
        if (shop ==null){
            modelMap.addAttribute(MallConstant.ATTR_NAME_EXCEPTION,MallConstant.MESSAGE_LOGIN_FAILED);
            return "shop-login";
        }

        String shopPwdDataBase = shop.getShopPwd();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        boolean matchesResult = passwordEncoder.matches(shopPswd,shopPwdDataBase);
        if (!matchesResult){
            modelMap.addAttribute(MallConstant.ATTR_NAME_EXCEPTION,MallConstant.MESSAGE_LOGIN_FAILED);
            return "shop-login";
        }

        session.setAttribute(MallConstant.ATTR_NAME_LOGIN_SHOP,shop);

        return "redirect:http://www.mall.com/portal/shop/to/shop/center";
    }

    @RequestMapping("/shop/logout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:http://www.mall.com/";
    }


}
