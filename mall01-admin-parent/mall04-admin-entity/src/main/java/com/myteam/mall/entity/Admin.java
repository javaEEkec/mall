package com.myteam.mall.entity;

/**
 * @author mzx
 */
public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPswd;

    private String adminType;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminPswd, String adminType) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPswd = adminPswd;
        this.adminType = adminType;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPswd() {
        return adminPswd;
    }

    public void setAdminPswd(String adminPswd) {
        this.adminPswd = adminPswd == null ? null : adminPswd.trim();
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType == null ? null : adminType.trim();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPswd='" + adminPswd + '\'' +
                ", adminType='" + adminType + '\'' +
                '}';
    }
}