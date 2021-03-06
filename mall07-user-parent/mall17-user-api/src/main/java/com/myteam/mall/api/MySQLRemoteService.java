package com.myteam.mall.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.po.*;
import com.myteam.mall.entity.vo.OrderProductUserVO;
import com.myteam.mall.entity.vo.OrderVO;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("myteam-mall-mysql")
public interface MySQLRemoteService {

    @RequestMapping("/get/userpo/by/user/acct/remote")
    ResultEntity<UserPO> getUserPOByUserAcctRemote(@RequestParam("userAcct") String userAcct);

    /**
     * 保存用户
     * @param userPO 用户的持久化数据
     * @return
     */
    @RequestMapping("/save/user/remote")
    ResultEntity<String> saveUser(@RequestBody UserPO userPO);


    @RequestMapping(value = "/save/order/remote")
    ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO);

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    @RequestMapping("/get/userpo/by/user/id/remote")
    ResultEntity<UserPO> getUserPOByUserId(@RequestParam("userId") Integer userId);

    /**
     * 获取首页显示商品分类信息
     * @return ResultEntity<List<PortalCategoryVO>>
     */
    @RequestMapping("/get/portal/category/data/remote")
    public ResultEntity<List<PortalCategoryVO>> getPortalCategoryDataRemote();

    /**
     * 根据关键词查询商品的分页信息
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/online/product/get/page/info/remote")
    public ResultEntity<PageInfo<ProductSimpleVO>> getProductSimpleVOPageInfoRemote(@RequestParam("keyword") String keyword,
                                                                                    @RequestParam("pageNum") Integer pageNum,
                                                                                    @RequestParam("pageSize") Integer pageSize);

    /**
     * 根据商品编号返回商品的详细信息
     * @param productId 产品编号
     * @return
     */
    @RequestMapping("online/product/get/detail/remote")
    ResultEntity<OnlineProduct> getProductById(@RequestParam("productId") Integer productId);

    /**
     * 将待审核入库的商品信息上传至后台
     * @param examineProduct
     */
    @RequestMapping("save/examine/product/remote")
    ResultEntity<String> saveExamineProduct(@RequestBody ExamineProduct examineProduct);

    /**
     * 将商户提交的注册申请提交给后台
     * @param shopCheck 商户注册信息
     * @return
     */
    @RequestMapping("save/shop/check/remote")
    ResultEntity<String> saveShopCheck(@RequestBody ShopCheck shopCheck);

    @RequestMapping("get/shop/by/acct/remote")
    ResultEntity<Shop> getShopByShopAcctRemote(@RequestParam("shopAcct") String shopAcct);

    @RequestMapping("get/shop/by/id/remote")
    ResultEntity<Shop> getShopByIdRemote(@RequestParam("shopId") Integer shopId);

    @RequestMapping("get/order/po/by/userId/remote")
    ResultEntity<List<OrderProductUserVO>> getOrderPOByUserIdRemote(@RequestParam("userId") Integer userId);

    @RequestMapping("insert/order/inner/product/remote")
    ResultEntity<String> insertOrderWithId(@RequestParam("orderId") Integer orderId,@RequestParam("productId") Integer productId);

    @RequestMapping("/save/complaint/remote")
    ResultEntity<String> saveComplaintRemote(@RequestBody ComplaintPO complaintPO);
}
