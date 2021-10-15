package com.myteam.mall.handler;

import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;

/**
 * @author mzx
 */
@Controller
public class OrderHandler {

    @Autowired
    private MySQLRemoteService mysqlRemoteService;

    @RequestMapping("to/order/confirm/page/{productId}/{buyNum}")
    public String toOrderPage(@PathVariable("productId") Integer productId, @PathVariable("buyNum") Integer buyNum, HttpSession session){
        ResultEntity<OnlineProduct> resultEntity = mysqlRemoteService.getProductById(productId);

        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())){
            OnlineProduct onlineProduct = resultEntity.getData();
            session.setAttribute("orderProduct",onlineProduct);
            session.setAttribute("buyNum",buyNum);
        }

        return "order-confirm";
    }

}
