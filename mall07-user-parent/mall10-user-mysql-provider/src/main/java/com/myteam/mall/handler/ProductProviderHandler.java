package com.myteam.mall.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.service.api.ProductService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljs
 */
@RestController
public class ProductProviderHandler {

    @Autowired
    private ProductService productService;

    @RequestMapping("/get/portal/category/data/remote")
    public ResultEntity<List<PortalCategoryVO>> getPortalCategoryDataRemote(){
        try {
            List<PortalCategoryVO> portalCategoryVOList = productService.getPortalCategoryVO();
            return ResultEntity.successWithData(portalCategoryVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    @RequestMapping("/online/product/get/page/info/remote")
    public ResultEntity<PageInfo<ProductSimpleVO>> getProductSimpleVOPageInfoRemote(String keyword,Integer pageNum,Integer pageSize){
        try {
            PageInfo<ProductSimpleVO> productsPageInfo = productService.getProductsPageInfo(keyword, pageNum, pageSize);
            return ResultEntity.successWithData(productsPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}