package com.myteam.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author ljs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineProductVO {

    private Integer productId;

    private String productName;

    private String brand;

    private String category;

    private BigDecimal price;

    private Integer onlineNum;

    private Shop shop;
}
