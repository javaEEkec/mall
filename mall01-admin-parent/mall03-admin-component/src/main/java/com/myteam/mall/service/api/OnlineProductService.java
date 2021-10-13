package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.entity.OnlineProduct;
import com.myteam.mall.entity.OnlineProductVO;

/**
 * @author mzx
 */
public interface OnlineProductService {

    PageInfo<OnlineProductVO> getOnlineProductPageInfo(String keyword, Integer pageNum, Integer pageSize);

    OnlineProduct getOnlineProductById(Integer productId);

    void saveOnlineProduct(OnlineProduct onlineProduct);

    void deleteOnlineProduct(Integer productId);

    void updateOnlineProductNum(Integer productId, Integer changeNum);
}
