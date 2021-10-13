package com.myteam.mall.service.impl;

import com.myteam.mall.entity.po.Shop;
import com.myteam.mall.entity.po.ShopCheck;
import com.myteam.mall.mapper.ShopCheckMapper;
import com.myteam.mall.mapper.ShopMapper;
import com.myteam.mall.service.api.ShopService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mzx
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopCheckMapper shopMapper;

    @Override
    public void saveShopCheck(ShopCheck shopCheck) {
        shopMapper.insert(shopCheck);
    }
}
