package com.young.entity.consumeRecordEntity;

import java.io.Serializable;
import java.util.Date;

public class ConsumeRecordEntity implements Serializable {

    static final long serialVersionUID = 1L;
    int recordId;
    int userId;
    int value;
    Date time;

    public ConsumeRecordEntity() {
        super();
    }

    public ConsumeRecordEntity(int userId, int value) {
        super();
        this.userId = userId;
        this.value = value;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
