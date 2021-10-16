package com.myteam.mall.entity.po;

public class ShopCheck {
    private Integer id;

    private String shopAcct;

    private String shopPwd;

    private String shopName;

    private String shopPersonincharge;

    private String shopPersonphone;

    private String shopCheckStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getShopCheckStatus() {
        return shopCheckStatus;
    }

    public void setShopCheckStatus(String shopCheckStatus) {
        this.shopCheckStatus = shopCheckStatus == null ? null : shopCheckStatus.trim();
    }
}