package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Order;
import com.myteam.mall.service.api.OrderService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    @RequestMapping("admin/get/order/page/info.json")
    public ResultEntity<PageInfo<Order>> getOrderPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<Order> orderPageInfo = orderService.getOrderPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(orderPageInfo);
    }

    @RequestMapping("update/order/status.json")
    public ResultEntity<String> updateOrderStatus(@RequestParam("orderId") Integer orderId){
        orderService.updateOrderStatus(orderId);
        return ResultEntity.successWithoutData();
    }

}
