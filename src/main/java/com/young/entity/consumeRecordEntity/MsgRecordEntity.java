package com.young.entity.consumeRecordEntity;

public class MsgRecordEntity extends ConsumeRecordEntity{

    public MsgRecordEntity() {
    }

    public MsgRecordEntity(int userId, int value) {
        super(userId, value);
    }

    @Override
    public String toString() {
        return "\n发送" + value +
                "条短信, 时间为" + time;
    }

}
