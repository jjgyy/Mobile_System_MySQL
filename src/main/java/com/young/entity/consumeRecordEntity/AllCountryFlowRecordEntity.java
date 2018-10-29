package com.young.entity.consumeRecordEntity;

public class AllCountryFlowRecordEntity extends ConsumeRecordEntity{

    public AllCountryFlowRecordEntity() {
    }

    public AllCountryFlowRecordEntity(int userId, int value) {
        super(userId, value);
    }

    @Override
    public String toString() {
        return "\n使用全国流量" + value +
                "MB, 时间为" + time;
    }

}
