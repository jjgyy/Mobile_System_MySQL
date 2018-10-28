package com.young.mapper;

import com.young.entity.PlanEntity;
import org.apache.ibatis.annotations.Insert;

public interface PlanMsgMapper {

    @Insert("INSERT INTO plan_msg(plan_id,mlimit,mcost) VALUES(#{planId}, #{msgLimit}, #{msgCost})")
    void insert(PlanEntity planEntity);

}
