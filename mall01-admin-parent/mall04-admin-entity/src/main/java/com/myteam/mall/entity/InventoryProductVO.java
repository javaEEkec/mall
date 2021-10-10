package com.myteam.mall.entity;

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
public class InventoryProductVO {

    private Integer productId;

    private String productName;

    private String brand;

    private String category;

    private BigDecimal price;

    private Integer inventoryNum;

    private Shop shop;
}
