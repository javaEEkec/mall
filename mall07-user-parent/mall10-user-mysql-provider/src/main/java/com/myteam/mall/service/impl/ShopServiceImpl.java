package com.myteam.mall.service.impl;

import com.myteam.mall.entity.po.Shop;
import com.myteam.mall.entity.po.ShopCheck;
import com.myteam.mall.entity.po.ShopExample;
import com.myteam.mall.mapper.ShopCheckMapper1;
import com.myteam.mall.mapper.ShopMapper1;
import com.myteam.mall.service.api.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mzx
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopCheckMapper1 shopCheckMapper;

    @Autowired
    private ShopMapper1 shopMapper;

    @Override
    public void saveShopCheck(ShopCheck shopCheck) {
        shopCheckMapper.insert(shopCheck);
    }

    @Override
    public Shop getShopByShopAcct(String shopAcct) {

        ShopExample shopExample = new ShopExample();

        ShopExample.Criteria criteria = shopExample.createCriteria();

        criteria.andShopAcctEqualTo(shopAcct);

        List<Shop> shops = shopMapper.selectByExample(shopExample);

        if (shops == null || shops.size() == 0 ){
            return null;
        }

        return shops.get(0);
    }

    @Override
    public Shop getShopById(Integer shopId) {
        return shopMapper.selectByPrimaryKey(shopId);
    }
}
