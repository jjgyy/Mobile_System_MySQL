package com.young.entity;

public class UserPlanEntity {

    private static final long serialVersionUID = 1L;
    private int userId;
    private int planId;
    private int del;

    public UserPlanEntity(int userId, int planId) {
        super();
        this.userId = userId;
        this.planId = planId;
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

    @Override
    public String toString() {
        return "\nUserPlanEntity{" +
                "userId=" + userId +
                ", planId=" + planId +
                '}';
    }

}
