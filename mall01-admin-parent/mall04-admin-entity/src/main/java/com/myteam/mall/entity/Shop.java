package com.myteam.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private Integer shopId;

    private String shopAcct;

    private String shopPwd;

    private String shopName;

    private String shopPersonincharge;

    private String shopPersonphone;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopAcct() {
        return shopAcct;
    }

    public void setShopAcct(String shopAcct) {
        this.shopAcct = shopAcct == null ? null : shopAcct.trim();
    }

    public String getShopPwd() {
        return shopPwd;
    }

    public void setShopPwd(String shopPwd) {
        this.shopPwd = shopPwd == null ? null : shopPwd.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopPersonincharge() {
        return shopPersonincharge;
    }

    public void setShopPersonincharge(String shopPersonincharge) {
        this.shopPersonincharge = shopPersonincharge == null ? null : shopPersonincharge.trim();
    }

    public String getShopPersonphone() {
        return shopPersonphone;
    }

    public void setShopPersonphone(String shopPersonphone) {
        this.shopPersonphone = shopPersonphone == null ? null : shopPersonphone.trim();
    }
}