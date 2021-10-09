package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.InventoryProduct;

public interface InventoryProductService {
    PageInfo<InventoryProduct> getProductPageInfo(String keyword,Integer pageNum,Integer pageSize);

    void saveInventoryProduct(InventoryProduct inventoryProduct);
}
