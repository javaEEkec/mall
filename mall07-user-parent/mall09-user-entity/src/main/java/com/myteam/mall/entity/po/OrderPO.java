package com.myteam.mall.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPO implements Serializable {

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderCouponId() {
        return orderCouponId;
    }

    public void setOrderCouponId(Integer orderCouponId) {
        this.orderCouponId = orderCouponId;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public BigDecimal getOrderOriginMoney() {
        return orderOriginMoney;
    }

    public void setOrderOriginMoney(BigDecimal orderOriginMoney) {
        this.orderOriginMoney = orderOriginMoney;
    }

    public BigDecimal getOrderMovingMoney() {
        return orderMovingMoney;
    }

    public void setOrderMovingMoney(BigDecimal orderMovingMoney) {
        this.orderMovingMoney = orderMovingMoney;
    }

    public BigDecimal getOrderScoretoMoney() {
        return orderScoretoMoney;
    }

    public void setOrderScoretoMoney(BigDecimal orderScoretoMoney) {
        this.orderScoretoMoney = orderScoretoMoney;
    }

    public BigDecimal getOrderCoupontoMoney() {
        return orderCoupontoMoney;
    }

    public void setOrderCoupontoMoney(BigDecimal orderCoupontoMoney) {
        this.orderCoupontoMoney = orderCoupontoMoney;
    }

    public BigDecimal getOrderToPay() {
        return orderToPay;
    }

    public void setOrderToPay(BigDecimal orderToPay) {
        this.orderToPay = orderToPay;
    }

    public String getOrderCogsigneeName() {
        return orderCogsigneeName;
    }

    public void setOrderCogsigneeName(String orderCogsigneeName) {
        this.orderCogsigneeName = orderCogsigneeName == null ? null : orderCogsigneeName.trim();
    }

    public String getOrderCogsigneePhone() {
        return orderCogsigneePhone;
    }

    public void setOrderCogsigneePhone(String orderCogsigneePhone) {
        this.orderCogsigneePhone = orderCogsigneePhone == null ? null : orderCogsigneePhone.trim();
    }

    public String getOrderCogsigneeAddress() {
        return orderCogsigneeAddress;
    }

    public void setOrderCogsigneeAddress(String orderCogsigneeAddress) {
        this.orderCogsigneeAddress = orderCogsigneeAddress == null ? null : orderCogsigneeAddress.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getOrderPayingTime() {
        return orderPayingTime;
    }

    public void setOrderPayingTime(Date orderPayingTime) {
        this.orderPayingTime = orderPayingTime;
    }

    public Date getOrderReceivingTime() {
        return orderReceivingTime;
    }

    public void setOrderReceivingTime(Date orderReceivingTime) {
        this.orderReceivingTime = orderReceivingTime;
    }
}