package com.myteam.mall.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductUserVO {

    private Integer orderId;
    private Integer orderUserId;
    private BigDecimal orderOriginMoney;
    private BigDecimal orderToPay;
    private String orderCogsigneeName;
    private String orderCogsigneePhone;
    private String orderCogsigneeAddress;
    private String orderStatus;
    private Date orderPayingTime;
    private Integer productId;
    private String productName;

}
