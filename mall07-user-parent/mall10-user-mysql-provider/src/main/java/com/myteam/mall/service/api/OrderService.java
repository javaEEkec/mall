package com.myteam.mall.service.api;

import com.myteam.mall.entity.po.OrderPO;

public interface OrderService {
    void saveOrderService(OrderPO orderPO);

    OrderPO getLastOrder();

    void insertInnerOrderProduct(Integer orderId,Integer productId);
}
