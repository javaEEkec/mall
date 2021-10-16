package com.myteam.mall.service.api;

import com.myteam.mall.entity.po.OrderPO;
import com.myteam.mall.entity.vo.OrderProductUserVO;

import java.util.List;

public interface OrderService {
    void saveOrderService(OrderPO orderPO);

    OrderPO getLastOrder();

    void insertInnerOrderProduct(Integer orderId,Integer productId);

    List<OrderProductUserVO> getOrderByUserId(Integer userId);
}
