package com.myteam.mall.handler;

import com.myteam.mall.entity.po.Shop;
import com.myteam.mall.entity.po.ShopCheck;
import com.myteam.mall.service.api.ShopService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopProviderHandler {

    @Autowired
    private ShopService shopService;

    @RequestMapping("save/shop/check/remote")
    ResultEntity<String> saveShopCheck(@RequestBody ShopCheck shopCheck){
        shopService.saveShopCheck(shopCheck);
        return ResultEntity.successWithoutData();
    }
    @RequestMapping("get/shop/by/acct/remote")
    ResultEntity<Shop> getShopByShopAcctRemote(@RequestParam("shopAcct") String shopAcct){
        try{
            Shop shop = shopService.getShopByShopAcct(shopAcct);

            return ResultEntity.successWithData(shop);
        }catch (Exception e){
            e.printStackTrace();
            // 3. 异常则返回异常信息
            return ResultEntity.failed(e.getMessage());
        }
    }
}
