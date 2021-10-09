package com.myteam.mall.entity;

public class Shop {
    private Integer shopId;

    private String shopAcct;

    private String shopName;

    private String shopPersonincharge;

    private String shopPersonphone;

    public Shop() {
    }

    public Shop(Integer shopId, String shopAcct, String shopName, String shopPersonincharge, String shopPersonphone) {
        this.shopId = shopId;
        this.shopAcct = shopAcct;
        this.shopName = shopName;
        this.shopPersonincharge = shopPersonincharge;
        this.shopPersonphone = shopPersonphone;
    }

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

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopAcct='" + shopAcct + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPersonincharge='" + shopPersonincharge + '\'' +
                ", shopPersonphone='" + shopPersonphone + '\'' +
                '}';
    }
}