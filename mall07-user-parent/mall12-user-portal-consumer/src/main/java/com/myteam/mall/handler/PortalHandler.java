package com.myteam.mall.handler;


import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author mzx
 */
@Controller
public class PortalHandler {

    @Autowired
    private MySQLRemoteService mysqlRemoteService;

    @RequestMapping("/")
    public String showPortalPage(Model model){
        ResultEntity<List<PortalCategoryVO>> resultEntity = mysqlRemoteService.getPortalCategoryDataRemote();

        String result = resultEntity.getResult();

        if (ResultEntity.SUCCESS.equals(result)){
            List<PortalCategoryVO> list = resultEntity.getData();

            model.addAttribute(MallConstant.ATTR_NAME_PORTAL_DATA, list);
        }
        return "portal";
    }

    @RequestMapping("/get/portal/category/product/data")
    @ResponseBody
    public ResultEntity<List<PortalCategoryVO>> getPortalCategoryProductData(){
        return mysqlRemoteService.getPortalCategoryDataRemote();
    }



}
