package com.myteam.mall.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
