package com.young.mapper;

import com.young.entity.PlanEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface PlanCallMapper {

    @Insert("INSERT INTO plan_call(plan_id,climit,ccost) VALUES(#{planId}, #{callLimit}, #{callCost})")
    void insert(PlanEntity planEntity);

}
