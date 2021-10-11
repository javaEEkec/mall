package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.entity.InventoryProductVO;
import com.myteam.mall.entity.OnlineProduct;
import com.myteam.mall.service.api.InventoryProductService;
import com.myteam.mall.service.api.OnlineProductService;
import com.myteam.mall.util.MallUtil;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * @author ljs
 */
@RestController
public class InventoryProductHandler {

    @Autowired
    private InventoryProductService inventoryProductService;

    @Autowired
    private OnlineProductService onlineProductService;

    @RequestMapping("admin/inventory/product/page/info.json")
    public ResultEntity<PageInfo<InventoryProductVO>> getInventoryProductPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<InventoryProductVO> pageInfo = inventoryProductService.getProductPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(pageInfo);
    }


    @RequestMapping("admin/get/inventory/product/detail.json")
    public ResultEntity<InventoryProduct> getInventoryProductDetail(Integer productId){
        InventoryProduct inventoryProductById = inventoryProductService.getInventoryProductById(productId);
        return ResultEntity.successWithData(inventoryProductById);
    }


    /**
     * 商品上架
     * @param productId 商品编号
     * @param onlineNum 上架数量
     * @return
     */
    @RequestMapping("admin/push/to/online/product.json")
    public ResultEntity<String> pushToOnlineProduct(Integer productId,Integer onlineNum){

        OnlineProduct onlineProduct = onlineProductService.getOnlineProductById(productId);
        //如果产品已经上架，则不允许操作
        if (onlineProduct != null){
            return ResultEntity.failed("产品已上架！");
        }
        InventoryProduct inventoryProduct = inventoryProductService.getInventoryProductById(productId);
        if (inventoryProduct != null){
            OnlineProduct onlineProduct1 = new OnlineProduct();
            BeanUtils.copyProperties(inventoryProduct,onlineProduct1);
            onlineProductService.saveOnlineProduct(onlineProduct1);
        }
        return ResultEntity.successWithoutData();
    }

    /**
     * 增减商品的库存
     * @param productId 商品编号
     * @param changeNum 正数表示增加商品库存，负数表示减少商品库存
     * @return
     */
    @RequestMapping("admin/change/inventory/product/num.json")
    public ResultEntity<String> changeInventoryProductNum(Integer productId,Integer changeNum){
        inventoryProductService.increaseOrDecreaseInventory(productId,changeNum);
        return ResultEntity.successWithoutData();
    }


}
