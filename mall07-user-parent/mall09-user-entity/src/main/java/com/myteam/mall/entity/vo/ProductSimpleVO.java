package com.myteam.mall.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 页面显示商品的简易信息
 * @author ljs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSimpleVO {

    private Integer productId;

    private String productName;

    private String brand;

    private BigDecimal price;

    private String productImg;
}
