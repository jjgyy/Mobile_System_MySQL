package com.young.entity.consumeRecordEntity;

public class LocalFlowRecordEntity extends ConsumeRecordEntity{

    public LocalFlowRecordEntity() {
    }

    public LocalFlowRecordEntity(int userId, int value) {
        super(userId, value);
    }

    @Override
    public String toString() {
        return "\n使用本地流量" + value +
                "MB, 时间为" + time;
    }
}
