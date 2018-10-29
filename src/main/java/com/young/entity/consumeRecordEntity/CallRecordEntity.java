package com.young.entity.consumeRecordEntity;

public class CallRecordEntity extends ConsumeRecordEntity {

    public CallRecordEntity() {
    }

    public CallRecordEntity(int userId, int value) {
        super(userId, value);
    }

    @Override
    public String toString() {
        return "\n通话" + value +
                "分钟, 时间为" + time;
    }

}
