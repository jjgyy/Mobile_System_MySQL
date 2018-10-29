package com.young.mapper;

import com.young.entity.PlanEntity;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface PlanLocalFlowMapper {

    @Insert("INSERT INTO plan_lflow(plan_id,llimit,lcost) VALUES(#{planId}, #{localFlowLimit}, #{localFlowCost})")
    void insert(PlanEntity planEntity);

}
