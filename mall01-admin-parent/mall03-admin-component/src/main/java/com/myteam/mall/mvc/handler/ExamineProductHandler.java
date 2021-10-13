package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.ExamineProduct;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.service.api.ExamineService;
import com.myteam.mall.service.api.InventoryProductService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljs
 */
@RestController
public class ExamineProductHandler {

    @Autowired
    private ExamineService examineService;

    @Autowired
    private InventoryProductService inventoryProductService;

    /**
     * 后台管理系统显示审核的分页信息
     * @return
     */
    @RequestMapping("get/examine/product/page/info.json")
    public ResultEntity<PageInfo<ExamineProduct>> getExamineProductPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<ExamineProduct> examineProductPageInfo = examineService.getExamineProductPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(examineProductPageInfo);
    }

    /**
     * 查看提交的商品的详细信息
     * @param id
     * @return
     */
    @RequestMapping("get/examine/product/detail/by/id.json")
    public ResultEntity<ExamineProduct> getExamineProductById(Integer id){
        ExamineProduct examineProduct = examineService.getExamineProductById(id);
        return ResultEntity.successWithData(examineProduct);
    }
    /**
     * 审核商品信息，审核通过的就入库，status="审核通过"，审核不通过就返回审核不通过信息，status=“审核不通过”
     * 根据传入的编号id，对商品的状态进行操作,operation=0:审核通过入库，operation=1，审核不通过，不入库
     */
    @RequestMapping("check/product/by/id.json")
    public ResultEntity<String> checkExamineProduct(Integer id,Integer operation){
        examineService.updateExamineProductStatus(id,operation);
        //如果审核操作为通过
        if (operation == 0){
            ExamineProduct examineProduct = examineService.getExamineProductById(id);
            if (examineProduct == null){
                return ResultEntity.failed("找不到该商品");
            }
            InventoryProduct inventoryProduct = new InventoryProduct();
            //复制属性
            BeanUtils.copyProperties(examineProduct,inventoryProduct);
            inventoryProductService.saveInventoryProduct(inventoryProduct);
        }
        return ResultEntity.successWithoutData();
    }

}
