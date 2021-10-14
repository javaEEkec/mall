package com.myteam.mall.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.config.OBSProperties;
import com.myteam.mall.config.OSSProperties;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.po.ExamineProduct;
import com.myteam.mall.entity.po.InventoryProduct;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.vo.ExamineProductVO;
import com.myteam.mall.entity.vo.ProductDetailVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.util.MallUtil;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
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

    @Autowired
    private OBSProperties obsProperties;

    @Autowired
    private OSSProperties ossProperties;

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
            return ResultEntity.failed(MallConstant.MESSAGE_PRODUCT_DETAIL_NO_FOUND);
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

    @ResponseBody
    @RequestMapping("/shop/commit/inventory/product/to/examine")
    public ResultEntity<String> saveExamineProduct(ExamineProductVO examineProductVo,
                                                   MultipartFile picture) throws IOException, ParseException {

        boolean pictureIsEmpty = true;

        if (picture != null){
            pictureIsEmpty = picture.isEmpty();
        }
        if (pictureIsEmpty){
            return ResultEntity.failed(MallConstant.MESSAGE_PICTURE_EMPTY);
        }

        ResultEntity<String> uploadPictureEntity = MallUtil.uploadFileToOss(
                ossProperties.getEndPoint(),
                ossProperties.getAccessKeyId(),
                ossProperties.getAccessKeySecret(),
                picture.getInputStream(),
                ossProperties.getBucketName(),
                ossProperties.getBucketDomain(),
                picture.getOriginalFilename());

        String result = uploadPictureEntity.getResult();
        //判断图片上传是否成功
        if (ResultEntity.SUCCESS.equals(result)){
            //如果成功则从返回的数据中获取图片的访问路径
            String imgPath = uploadPictureEntity.getData();
            examineProductVo.setProductImg(imgPath);
            examineProductVo.setStatus("待审核");
        }else {
            return ResultEntity.failed("上传图片失败");
        }
        ExamineProduct examineProduct = new ExamineProduct();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将日期字符串转换为Date类型
        Date produceTime = dateFormat.parse(examineProductVo.getProduceTime());
        Date endTime = dateFormat.parse(examineProductVo.getEndTime());
        //复制属性
        BeanUtils.copyProperties(examineProductVo,examineProduct);
        examineProduct.setProduceTime(produceTime);
        examineProduct.setEndTime(endTime);

        ResultEntity<String> resultEntity = mysqlRemoteService.saveExamineProduct(examineProduct);
        if (ResultEntity.FAILED.equals(resultEntity.getResult())){
            return ResultEntity.failed(resultEntity.getMessage());
        }
        return ResultEntity.successWithoutData();
    }
}
