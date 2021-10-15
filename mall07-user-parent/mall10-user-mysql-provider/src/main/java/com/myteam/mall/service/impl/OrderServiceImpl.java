package com.myteam.mall.service.impl;

import com.myteam.mall.entity.po.OrderPO;
import com.myteam.mall.mapper.OrderPOMapper;
import com.myteam.mall.service.api.OrderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderPOMapper orderPOMapper;

    @Override
    public void saveOrderService(OrderPO orderPO) {
        orderPOMapper.insert(orderPO);
    }

    @Override
    public OrderPO getLastOrder() {
        return orderPOMapper.getLastOrder();
    }

    @Override
    public void insertInnerOrderProduct(Integer orderId,Integer productId) {
        orderPOMapper.insertOrderWithProductforId(orderId,productId);
    }
}
