package com.myteam.mall.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.po.ExamineProduct;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.service.api.ExamineProductService;
import com.myteam.mall.service.api.ProductService;
import com.myteam.mall.util.ResultEntity;
import com.netflix.discovery.converters.Auto;
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

    @Autowired
    private ExamineProductService examineProductService;

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

    @RequestMapping("online/product/get/detail/remote")
    public ResultEntity<OnlineProduct> getProductById(Integer productId){
        try {
            OnlineProduct onlineProduct = productService.getProductById(productId);
            return ResultEntity.successWithData(onlineProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

    }

    /**
     * 将待审核入库的商品信息上传至后台
     * @param examineProduct
     */
    @RequestMapping("save/examine/product/remote")
    ResultEntity<String> saveExamineProduct(ExamineProduct examineProduct){
        examineProductService.saveExamineProduct(examineProduct);
        return ResultEntity.successWithoutData();
    }

}
