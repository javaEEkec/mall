package com.myteam.mall.entity.vo;

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

    private Integer shopId;

    private BigDecimal price;

    private String productImg;

    private String category;

    private String produceTime;

    private String describe;

    private String activityType;

    private String endTime;

    private Integer inventoryNum;

    private String status;
}
