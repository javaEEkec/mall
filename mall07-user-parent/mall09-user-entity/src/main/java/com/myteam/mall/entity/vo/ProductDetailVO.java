package com.myteam.mall.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ljs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailVO {
    private Integer productId;

    private String productName;

    private String brand;

    private Integer shopId;

    private BigDecimal price;

    private String productImg;

    private String category;

    private String produceTime;

    private String description;

    private String activityType;

    private String endTime;

}
