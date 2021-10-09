package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Shop;
import com.myteam.mall.service.api.ShopService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzx
 */
@RestController
public class ShopHandler {

    @Autowired
    private ShopService shopService;

    @RequestMapping("/admin/do/save/shop.json")
    public ResultEntity<String> saveShop(Shop shop){
        System.out.println(shop);
        shopService.saveShop(shop);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/admin/get/shop/page/info.json")
    public ResultEntity<PageInfo<Shop>> getShopPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<Shop> pageInfo = shopService.getPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(pageInfo);
    }
}