package com.myteam.mall.handler;

import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.po.OrderPO;
import com.myteam.mall.entity.vo.OrderProductUserVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @author mzx
 */
@Controller
public class OrderHandler {

    @Autowired
    private MySQLRemoteService mysqlRemoteService;

    @RequestMapping("/to/order/confirm/page/{productId}/{buyNum}")
    public String toOrderPage(@PathVariable("productId") Integer productId, @PathVariable("buyNum") Integer buyNum, HttpSession session){
        ResultEntity<OnlineProduct> resultEntity = mysqlRemoteService.getProductById(productId);

        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())){
            OnlineProduct onlineProduct = resultEntity.getData();
            session.setAttribute("orderProduct",onlineProduct);
            session.setAttribute("buyNum",buyNum);
        }

        return "order-confirm";
    }

    @ResponseBody
    @RequestMapping("/get/order/by/userId")
    public ResultEntity<List<OrderProductUserVO>> getOrderPOByUserId(Integer userId){
        ResultEntity<List<OrderProductUserVO>> resultEntity = mysqlRemoteService.getOrderPOByUserIdRemote(userId);
        if (ResultEntity.FAILED.equals(resultEntity.getResult())){
            return ResultEntity.failed(resultEntity.getMessage());
        }

        if (resultEntity.getData() == null){
            return ResultEntity.failed("该用户没有订单");
        }
        return resultEntity;
    }


    @RequestMapping("/to/report/page/{userId}/{productId}/{productName}")
    public String toReportPage(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId, @PathVariable("productName") String productName, ModelMap modelMap){
        modelMap.addAttribute("userId",userId);
        modelMap.addAttribute("productId",productId);
        modelMap.addAttribute("productName",productName);

        return "report";
    }


}
