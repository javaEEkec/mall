package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Order;

import java.util.List;

public interface OrderService {

    PageInfo<Order> getOrderPageInfo(String keyword,Integer pageNum,Integer pageSize);

    void updateOrderStatus(Integer orderId);
}
