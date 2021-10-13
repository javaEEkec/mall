package com.myteam.mall.handler;

import com.myteam.mall.entity.po.ShopCheck;
import com.myteam.mall.service.api.ShopService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopProviderHandler {

    @Autowired
    private ShopService shopService;

    @RequestMapping("save/shop/check/remote")
    ResultEntity<String> saveShopCheck(ShopCheck shopCheck){
        shopService.saveShopCheck(shopCheck);
        return ResultEntity.successWithoutData();
    }
}
