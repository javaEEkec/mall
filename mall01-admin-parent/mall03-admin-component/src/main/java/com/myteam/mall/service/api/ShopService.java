package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Shop;
import org.springframework.stereotype.Service;

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
}
