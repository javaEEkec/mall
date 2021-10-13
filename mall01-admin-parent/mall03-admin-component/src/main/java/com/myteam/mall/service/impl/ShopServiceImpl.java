package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.Shop;
import com.myteam.mall.entity.ShopCheck;
import com.myteam.mall.entity.ShopCheckExample;
import com.myteam.mall.entity.ShopExample;
import com.myteam.mall.exception.ShopAcctAlreadyInUseException;
import com.myteam.mall.mapper.ShopCheckMapper;
import com.myteam.mall.mapper.ShopMapper;
import com.myteam.mall.service.api.ShopService;
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

    @Autowired
    private ShopCheckMapper shopCheckMapper;

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

    @Override
    public PageInfo<ShopCheck> getCheckPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShopCheck> list = shopCheckMapper.selectShopCheckByKeyword(keyword);
        return new PageInfo<>(list);
    }

    @Override
    public void updateShopCheckStatus(Integer id, Integer operation) {
        String status = operation==0?"审核通过":"审核不通过";

        //封装查询条件
        ShopCheckExample example = new ShopCheckExample();
        ShopCheckExample.Criteria criteria = example.createCriteria();

        criteria.andIdEqualTo(id);

        ShopCheck shopCheck = new ShopCheck();
        shopCheck.setShopCheckStatus(status);

        shopCheckMapper.updateByExampleSelective(shopCheck,example);
    }

    @Override
    public List<Shop> getShopByAcct(String shopAcct) {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria criteria = shopExample.createCriteria();
        criteria.andShopAcctEqualTo(shopAcct);
        return shopMapper.selectByExample(shopExample);
    }

    @Override
    public ShopCheck getShopCheckById(Integer id) {
        return shopCheckMapper.selectByPrimaryKey(id);
    }
}
