package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by mjli on 2018/7/4.
 */
public class Admin implements Serializable {
    private String adminId;
    private String adminName;
    private String adminPwd;
    private String adminSalt;
    private int adminStatus;

    public Admin() {

    }

    public Admin(String adminId, String adminName, String adminPwd, String adminSalt, int adminStatus) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminSalt = adminSalt;
        this.adminStatus = adminStatus;
    }

    public Admin(String adminName, String adminPwd, String adminSalt, int adminStatus) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminSalt = adminSalt;
        this.adminStatus = adminStatus;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminSalt='" + adminSalt + '\'' +
                ", adminStatus=" + adminStatus +
                '}';
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminSalt() {
        return adminSalt;
    }

    public void setAdminSalt(String adminSalt) {
        this.adminSalt = adminSalt;
    }

    public int getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(int adminStatus) {
        this.adminStatus = adminStatus;
    }
}
