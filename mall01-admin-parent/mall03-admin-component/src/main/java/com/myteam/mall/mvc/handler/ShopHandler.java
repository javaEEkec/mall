package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Shop;
import com.myteam.mall.entity.ShopCheck;
import com.myteam.mall.service.api.ShopService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mzx
 */
@RestController
public class ShopHandler {

    @Autowired
    private ShopService shopService;

    @RequestMapping("/admin/do/save/shop.json")
    public ResultEntity<String> saveShop(Shop shop){
        shopService.saveShop(shop);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/admin/get/shop/page/info.json")
    public ResultEntity<PageInfo<Shop>> getShopPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<Shop> pageInfo = shopService.getPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(pageInfo);
    }

    /**
     * 商家入驻审核表
     */
    @RequestMapping("/admin/check/shop/page/info.json")
    public ResultEntity<PageInfo<ShopCheck>> getShopCheckPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        System.out.println("控制层方法");
        PageInfo<ShopCheck> shopCheckPageInfo = shopService.getCheckPageInfo(keyword,pageNum,pageSize);
        return ResultEntity.successWithData(shopCheckPageInfo);
    }

    /**
     * 审核是否通过商家入驻
     * @param id
     * @return
     */
    @RequestMapping("check/shop.json")
    public ResultEntity<String> checkShopRegister(Integer id,String shopAcct,Integer operation){
        shopService.updateShopCheckStatus(id,operation);

        if (operation == 0){
            List<Shop> shopByAcct = shopService.getShopByAcct(shopAcct);
            if (shopByAcct!=null && shopByAcct.size() !=0 ){
                return ResultEntity.failed("账户已存在");
            }
            Shop shop = new Shop();
            ShopCheck shopCheck = shopService.getShopCheckById(id);
            BeanUtils.copyProperties(shopCheck,shop);
            shopService.saveShop(shop);
        }
        return ResultEntity.successWithoutData();
    }


    @RequestMapping("get/shop/check/detail/by/id.json")
    public ResultEntity<ShopCheck> getShopCheckById(Integer id){
        ShopCheck shopCheckById = shopService.getShopCheckById(id);
        return ResultEntity.successWithData(shopCheckById);
    }
}