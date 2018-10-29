package com.young.entity;

import java.util.List;

public class BillEntity {

    private int callLimit;
    private double callCost;
    private int msgLimit;
    private double msgCost;
    private int localFlowLimit;
    private double localFlowCost;
    private int allCountryFlowLimit;
    private double allCountryFlowCost;
    private double planCost;

    private int callValue;
    private int msgValue;
    private int localFlowValue;
    private int allCountryFlowValue;

    public BillEntity(PlanEntity plan, int callValue, int msgValue, int localFlowValue, int allCountryFlowValue) {
        this.callLimit = plan.getCallLimit();
        this.callCost = plan.getCallCost();
        this.msgLimit = plan.getMsgLimit();
        this.msgCost = plan.getMsgCost();
        this.localFlowLimit = plan.getLocalFlowLimit();
        this.localFlowCost = plan.getLocalFlowCost();
        this.allCountryFlowLimit = plan.getAllCountryFlowLimit();
        this.allCountryFlowCost = plan.getAllCountryFlowCost();

        this.planCost = plan.getCost();

        this.callValue = callValue;
        this.msgValue = msgValue;
        this.localFlowValue = localFlowValue;
        this.allCountryFlowValue = allCountryFlowValue;
    }

    public double getPlanCost() {
        return planCost;
    }

    public double getBillCallCost() {
        if (callLimit == -1) {
            return callCost * callValue;
        }
        if (callLimit >= callValue) {
            return 0.0;
        }
        if (callLimit < callValue) {
            return callCost * (callValue - callLimit);
        }
        return 0.0;
    }

    public double getBillMsgCost() {
        if (msgLimit == -1) {
            return msgCost * msgValue;
        }
        if (msgLimit >= msgValue) {
            return 0.0;
        }
        if (msgLimit < msgValue) {
            return msgCost * (msgValue - msgLimit);
        }
        return 0.0;
    }

    public double getBillLocalFlowCost() {
        if (localFlowLimit == -1) {
            return localFlowCost * localFlowValue;
        }
        if (localFlowLimit >= localFlowValue) {
            return 0.0;
        }
        if (localFlowLimit < localFlowValue) {
            return localFlowCost * (localFlowValue - localFlowLimit);
        }
        return 0.0;
    }

    public double getBillAllCountryFlowCost() {
        if (allCountryFlowLimit == -1) {
            return allCountryFlowCost * allCountryFlowValue;
        }
        if (allCountryFlowLimit >= allCountryFlowValue) {
            return 0.0;
        }
        if (allCountryFlowLimit < allCountryFlowValue) {
            return allCountryFlowCost * (allCountryFlowValue - allCountryFlowLimit);
        }
        return 0.0;
    }

    public double getBillCost() {
        return this.planCost + getBillCallCost() + getBillMsgCost() + getBillLocalFlowCost() + getBillAllCountryFlowCost();
    }

}
