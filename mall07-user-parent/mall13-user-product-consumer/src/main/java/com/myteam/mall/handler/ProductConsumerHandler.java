package com.myteam.mall.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.vo.ProductDetailVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ljs
 */
@Controller
public class ProductConsumerHandler {

    @Autowired
    private MySQLRemoteService mysqlRemoteService;

    @ResponseBody
    @RequestMapping("get/products/page/info")
    public ResultEntity<PageInfo<ProductSimpleVO>> getProductsPageInfo(
            @RequestParam(value = "keyword",defaultValue = "") String keyword,
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "12") Integer pageSize
    ){
        return mysqlRemoteService.getProductSimpleVOPageInfoRemote(keyword,pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping("/get/online/product/detail/by/id")
    public ResultEntity<ProductDetailVO> getOnlineProductDetail(Integer productId){
        ResultEntity<OnlineProduct> resultEntity = mysqlRemoteService.getProductById(productId);
        OnlineProduct onlineProduct = resultEntity.getData();
        if (onlineProduct == null){
            return ResultEntity.failed("抱歉！查不到该商品的数据");
        }
        Date produceTime0 = onlineProduct.getProduceTime();
        Date endTime0 = onlineProduct.getEndTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String produceTime = formatter.format(produceTime0);
        String endTime = formatter.format(endTime0);
        ProductDetailVO productDetailVO = new ProductDetailVO();
        BeanUtils.copyProperties(onlineProduct,productDetailVO);
        productDetailVO.setProduceTime(produceTime);
        productDetailVO.setEndTime(endTime);
        return new ResultEntity<>(resultEntity.getResult(),resultEntity.getMessage(),productDetailVO);
    }
}
