package com.myteam.mall.handler;

import com.myteam.mall.entity.po.OrderPO;
import com.myteam.mall.entity.vo.OrderVO;
import com.myteam.mall.service.api.OrderService;
import com.myteam.mall.util.MallUtil;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderProviderHandler {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save/order/remote")
    ResultEntity<String> saveOrderRemote(@RequestBody OrderPO orderPO){
//        OrderPO orderPO = new OrderPO();
//        BeanUtils.copyProperties(orderVO,orderPO);
//        Integer productId = orderVO.getProductId();
//        OrderPO lastOrder = orderService.getLastOrder();
//        Integer orderId = lastOrder.getOrderId();
//        orderService.insertInnerOrderProduct(orderId,productId);
        orderService.saveOrderService(orderPO);
        return ResultEntity.successWithoutData();
    }
}
