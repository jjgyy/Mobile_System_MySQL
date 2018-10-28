package com.young.entity;

import java.util.Date;

public class UserPlanRecordEntity {

    private static final long serialVersionUID = 1L;
    private int planRecordId;
    private int userId;
    private int planId;
    private String type;
    private Date time;
    private int del;

    private String userName;
    private String planName;

    public UserPlanRecordEntity() {
        super();
    }

    public UserPlanRecordEntity(int userId, int planId, String type) {
        super();
        this.userId = userId;
        this.planId = planId;
        this.type = type;
    }

    public int getPlanRecordId() {
        return planRecordId;
    }

    public void setPlanRecordId(int planRecordId) {
        this.planRecordId = planRecordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Override
    public String toString() {
        return "\nUserPlanRecordEntity{" +
                "planRecordId=" + planRecordId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", planId=" + planId +
                ", planName='" + planName + '\'' +
                ", time=" + time +
                ", del=" + del +
                '}';
    }
}
