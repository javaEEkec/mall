package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Order;
import com.myteam.mall.entity.OrderExample;
import com.myteam.mall.mapper.OrderMapper;
import com.myteam.mall.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> getOrderPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Order> orderList = orderMapper.selectByKeyword(keyword);
        return new PageInfo<>(orderList);
    }

    @Override
    public void updateOrderStatus(Integer orderId) {
        OrderExample orderExample = new OrderExample();

        OrderExample.Criteria criteria = orderExample.createCriteria();

        criteria.andOrderIdEqualTo(orderId);

        Order order = new Order();

        order.setOrderStatus("已处理");

        orderMapper.updateByExampleSelective(order,orderExample);
    }
}
