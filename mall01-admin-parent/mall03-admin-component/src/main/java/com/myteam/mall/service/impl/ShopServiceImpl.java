package com.myteam.mall.service.impl;

import checkers.units.quals.A;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.Shop;
import com.myteam.mall.exception.LoginAcctAlreadyInUseException;
import com.myteam.mall.exception.ShopAcctAlreadyInUseException;
import com.myteam.mall.mapper.ShopMapper;
import com.myteam.mall.service.api.ShopService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mzx
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public void saveShop(Shop shop) {
        try {
            shopMapper.insert(shop);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof DuplicateKeyException){
                throw new ShopAcctAlreadyInUseException(MallConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
    }

    @Override
    public PageInfo<Shop> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Shop> shopList = shopMapper.selectShopByKeyWord(keyword);

        return new PageInfo<>(shopList);
    }
}
