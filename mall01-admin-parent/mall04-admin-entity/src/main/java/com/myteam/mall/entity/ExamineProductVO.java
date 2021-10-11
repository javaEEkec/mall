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
public class ExamineProductVO {

    private Integer id;

    private String productName;

    private String brand;

    private String category;

    private BigDecimal price;

    private Integer inventoryNum;

    private String status;

    private Shop shop;
}
