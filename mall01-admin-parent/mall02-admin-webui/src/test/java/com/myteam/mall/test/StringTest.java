package com.myteam.mall.test;

import com.myteam.mall.entity.ExamineProduct;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.util.MallUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class StringTest {

    @Test
    public void testMd5(){
        String source = "123456";
        String encoding = MallUtil.md5(source);
        System.out.println(encoding);
    }

    @Test
    public void testInteger(){
        Integer i = 100;
        Integer j = 0;
        System.out.println( -i <= 0);
    }

    @Test
    public void testInteger2(){
        String operator = operator(13);
        System.out.println(operator);
    }

    public String operator(Integer operator){
        return operator==0?"审核通过":"审核不通过";
    }

    @Test
    public void testCopy(){
        ExamineProduct examineProduct = new ExamineProduct(1,"productName","brand",1,new BigDecimal("3.02"),"imgPath"
        ,"category",new Date(),"describe","activityType",new Date(),100,"审核通过");
        InventoryProduct inventoryProduct = new InventoryProduct();
        BeanUtils.copyProperties(examineProduct,inventoryProduct);
        System.out.println(inventoryProduct);
    }
}
