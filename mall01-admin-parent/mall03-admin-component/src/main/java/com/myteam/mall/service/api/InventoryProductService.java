package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.entity.InventoryProductVO;

public interface InventoryProductService {
    InventoryProduct getInventoryProductById(Integer productId);


    PageInfo<InventoryProductVO> getProductPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void saveInventoryProduct(InventoryProduct inventoryProduct);
}
