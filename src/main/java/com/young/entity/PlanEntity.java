package com.young.entity;

import java.io.Serializable;
import java.util.List;

public class PlanEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private int planId;
    private Double cost;
    private String name;
    private String intro;
    private int keep;
    private int del;

    private int callLimit;
    private double callCost;
    private int msgLimit;
    private double msgCost;
    private int localFlowLimit;
    private double localFlowCost;
    private int allCountryFlowLimit;
    private double allCountryFlowCost;

    public PlanEntity() { super(); }

    public PlanEntity(double cost, String name, String intro, int callLimit, double callCost, int msgLimit, double msgCost, int localFlowLimit, double localFlowCost, int allCountryFlowLimit, double allCountryFlowCost) {
        super();
        this.cost = cost;
        this.name = name;
        this.intro = intro;

        this.callLimit = callLimit;
        this.callCost = callCost;
        this.msgLimit = msgLimit;
        this.msgCost = msgCost;
        this.localFlowLimit = localFlowLimit;
        this.localFlowCost = localFlowCost;
        this.allCountryFlowLimit = allCountryFlowLimit;
        this.allCountryFlowCost = allCountryFlowCost;
    }

    public PlanEntity(List<PlanEntity> plans) {
        super();
        this.planId = 0;
        this.name = "叠加后的套餐";
        this.intro = "用户套餐叠加后的资费标准";
        this.cost = 0.0;
        this.callLimit = 0;
        this.callCost = 0.0;
        this.msgLimit = 0;
        this.msgCost = 0.0;
        this.localFlowLimit = 0;
        this.localFlowCost = 0.0;
        this.allCountryFlowLimit = 0;
        this.allCountryFlowCost = 0.0;
        double minCallCost=plans.get(0).callCost;
        double minMsgCost=plans.get(0).msgCost;
        double minLocalFlowCost=plans.get(0).localFlowCost;
        double minAllCountryFlowCost=plans.get(0).allCountryFlowCost;
        for (PlanEntity plan : plans) {
            this.cost += plan.cost;
            this.callLimit += plan.callLimit == -1 ? 0 : plan.callLimit;
            this.msgLimit += plan.msgLimit == -1 ? 0 : plan.msgLimit;
            this.localFlowLimit += plan.localFlowLimit == -1 ? 0 : plan.localFlowLimit;
            this.allCountryFlowLimit += plan.allCountryFlowLimit == -1 ? 0 : plan.allCountryFlowLimit;
            minCallCost = plan.callCost < minCallCost ? plan.callCost : minCallCost;
            minMsgCost = plan.msgCost < minMsgCost ? plan.msgCost : minMsgCost;
            minLocalFlowCost = plan.localFlowCost < minLocalFlowCost ? plan.localFlowCost : minLocalFlowCost;
            minAllCountryFlowCost = plan.allCountryFlowCost < minAllCountryFlowCost ? plan.allCountryFlowCost : minAllCountryFlowCost;
        }
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getKeep() {
        return keep;
    }

    public void setKeep(int keep) {
        this.keep = keep;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getCallLimit() {
        return callLimit;
    }

    public void setCallLimit(int callLimit) {
        this.callLimit = callLimit;
    }

    public double getCallCost() {
        return callCost;
    }

    public void setCallCost(double callCost) {
        this.callCost = callCost;
    }

    public int getMsgLimit() {
        return msgLimit;
    }

    public void setMsgLimit(int msgLimit) {
        this.msgLimit = msgLimit;
    }

    public double getMsgCost() {
        return msgCost;
    }

    public void setMsgCost(double msgCost) {
        this.msgCost = msgCost;
    }

    public int getLocalFlowLimit() {
        return localFlowLimit;
    }

    public void setLocalFlowLimit(int localFlowLimit) {
        this.localFlowLimit = localFlowLimit;
    }

    public double getLocalFlowCost() {
        return localFlowCost;
    }

    public void setLocalFlowCost(double localFlowCost) {
        this.localFlowCost = localFlowCost;
    }

    public int getAllCountryFlowLimit() {
        return allCountryFlowLimit;
    }

    public void setAllCountryFlowLimit(int allCountryFlowLimit) {
        this.allCountryFlowLimit = allCountryFlowLimit;
    }

    public double getAllCountryFlowCost() {
        return allCountryFlowCost;
    }

    public void setAllCountryFlowCost(double allCountryFlowCost) {
        this.allCountryFlowCost = allCountryFlowCost;
    }

    @Override
    public String toString() {
        return "\nPlanEntity{" +
                "planId=" + planId +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", keep=" + keep +
                ", del=" + del +
                ", callLimit=" + callLimit +
                ", callCost=" + callCost +
                ", msgLimit=" + msgLimit +
                ", msgCost=" + msgCost +
                ", localFlowLimit=" + localFlowLimit +
                ", localFlowCost=" + localFlowCost +
                ", allCountryFlowLimit=" + allCountryFlowLimit +
                ", allCountryFlowCost=" + allCountryFlowCost +
                '}';
    }

}
