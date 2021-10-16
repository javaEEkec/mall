package com.myteam.mall.handler;

import com.myteam.mall.entity.po.OrderPO;
import com.myteam.mall.entity.vo.OrderProductUserVO;
import com.myteam.mall.entity.vo.OrderVO;
import com.myteam.mall.service.api.OrderService;
import com.myteam.mall.util.MallUtil;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderProviderHandler {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save/order/remote")
    ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO){
        OrderPO orderPO = new OrderPO();
        System.out.println(orderVO);
        BeanUtils.copyProperties(orderVO,orderPO);
        orderService.saveOrderService(orderPO);
        Integer productId = orderVO.getProductId();
        OrderPO lastOrder = orderService.getLastOrder();
        Integer orderId = lastOrder.getOrderId();
        orderService.insertInnerOrderProduct(orderId,productId);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("insert/order/inner/product/remote")
    ResultEntity<String> insertOrderWithId(@RequestParam("orderId") Integer orderId,@RequestParam("productId") Integer productId){
        orderService.insertInnerOrderProduct(orderId,productId);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("get/order/po/by/userId/remote")
    ResultEntity<List<OrderProductUserVO>> getOrderPOByUserIdRemote(@RequestParam("userId") Integer userId){
        List<OrderProductUserVO> order = orderService.getOrderByUserId(userId);
        return ResultEntity.successWithData(order);
    }
}
