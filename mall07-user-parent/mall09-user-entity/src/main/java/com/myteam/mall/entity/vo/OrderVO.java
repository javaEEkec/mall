package com.myteam.mall.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private Integer orderCouponId;

    private Integer orderUserId;

    private BigDecimal orderOriginMoney;

    private BigDecimal orderMovingMoney;

    private BigDecimal orderScoretoMoney;

    private BigDecimal orderCoupontoMoney;

    private BigDecimal orderToPay;

    private String orderCogsigneeName;

    private String orderCogsigneePhone;

    private String orderCogsigneeAddress;

    private String orderStatus;

    private Date orderPayingTime;

    private Date orderReceivingTime;

    private Integer productId;
}
