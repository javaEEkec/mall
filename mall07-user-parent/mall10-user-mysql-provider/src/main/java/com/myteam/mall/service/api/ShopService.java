package com.myteam.mall.service.api;

import com.myteam.mall.entity.po.Shop;
import com.myteam.mall.entity.po.ShopCheck;

/**
 * @author mzx
 */
public interface ShopService {


    void saveShopCheck(ShopCheck shopCheck);


    Shop getShopByShopAcct(String shopAcct);

    Shop getShopById(Integer shopId);
}
