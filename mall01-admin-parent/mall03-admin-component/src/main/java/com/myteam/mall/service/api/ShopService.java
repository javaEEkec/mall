package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Shop;
import com.myteam.mall.entity.ShopCheck;

import java.util.List;

/**
 * @author mzx
 */
public interface ShopService {

    void saveShop(Shop shop);

    /**
     * 获取商品的分页信息
     * @param keyword 关键词
     * @param pageNum 页码
     * @param pageSize
     * @return
     */
    PageInfo<Shop> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    PageInfo<ShopCheck> getCheckPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void updateShopCheckStatus(Integer id, Integer operation);

    List<Shop> getShopByAcct(String shopAcct);

    ShopCheck getShopCheckById(Integer id);
}
