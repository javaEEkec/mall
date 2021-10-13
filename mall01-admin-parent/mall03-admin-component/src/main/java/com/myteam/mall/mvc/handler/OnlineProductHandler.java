package com.myteam.mall.mvc.handler;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.OnlineProduct;
import com.myteam.mall.entity.OnlineProductVO;
import com.myteam.mall.service.api.InventoryProductService;
import com.myteam.mall.service.api.OnlineProductService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OnlineProductHandler {

    @Autowired
    private OnlineProductService onlineProductService;

    @Autowired
    private InventoryProductService inventoryProductService;

    @RequestMapping("admin/online/product/page/info.json")
    public ResultEntity<PageInfo<OnlineProductVO>> getOnlineProductVOPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<OnlineProductVO> onlineProductPageInfo = onlineProductService.getOnlineProductPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(onlineProductPageInfo);
    }

    @RequestMapping("admin/get/online/product/detail.json")
    public ResultEntity<OnlineProduct> getOnlineProductDetail(Integer productId){
        OnlineProduct onlineProduct = onlineProductService.getOnlineProductById(productId);
        return ResultEntity.successWithData(onlineProduct);
    }

    /**
     * 商品下架入库
     * @return
     */
    @RequestMapping("admin/do/sold/out/online/product.json")
    public ResultEntity<String> doSoldOutOnlineProduct(Integer productId){
        OnlineProduct onlineProductById = onlineProductService.getOnlineProductById(productId);
        Integer onlineNum = onlineProductById.getOnlineNum();
        onlineProductService.deleteOnlineProduct(productId);
        inventoryProductService.increaseOrDecreaseInventory(productId,onlineNum);
        return ResultEntity.successWithoutData();
    }

}
