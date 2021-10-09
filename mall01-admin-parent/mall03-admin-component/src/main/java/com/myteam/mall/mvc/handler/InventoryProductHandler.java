package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.service.api.InventoryProductService;
import com.myteam.mall.util.MallUtil;
import com.myteam.mall.util.ResultEntity;
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

    @RequestMapping("admin/inventory/product/page/info.json")
    public ResultEntity<PageInfo<InventoryProduct>> getInventoryProductPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<InventoryProduct> pageInfo = inventoryProductService.getProductPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(pageInfo);
    }

    @RequestMapping("admin/save/inventory/product.json")
    public ResultEntity<String> saveInventoryProduct(InventoryProduct inventoryProduct,
                                                     MultipartFile picture)throws IOException{

        ResultEntity<String> uploadPictureEntity = MallUtil.uploadFileToObs("https://obs.cn-south-1.myhuaweicloud.com",
                "C7MSZTKHGOAYXSVXQGZL",
                "0xh9SuIfOGDYzJgI8paIvywkojpWblgS2ijsuHll",
                picture.getInputStream(),
                "myteam001",
                "https://obs.cn-south-1.myhuaweicloud.com",
                picture.getOriginalFilename());

        String result = uploadPictureEntity.getResult();
        //判断图片上传是否成功
        if (ResultEntity.SUCCESS.equals(result)){
            //如果成功则从返回的数据中获取图片的访问路径
            String imgPath = uploadPictureEntity.getData();
            inventoryProduct.setProductImg(imgPath);
        }else {
            return ResultEntity.failed("上传图片失败");
        }
        inventoryProductService.saveInventoryProduct(inventoryProduct);
        return ResultEntity.successWithoutData();
    }





}
