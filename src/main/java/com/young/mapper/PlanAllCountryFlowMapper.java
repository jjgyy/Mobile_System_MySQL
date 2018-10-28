package com.young.mapper;

import com.young.entity.PlanEntity;
import org.apache.ibatis.annotations.Insert;

public interface PlanAllCountryFlowMapper {

    @Insert("INSERT INTO plan_aflow(plan_id,alimit,acost) VALUES(#{planId}, #{allCountryFlowLimit}, #{allCountryFlowCost})")
    void insert(PlanEntity planEntity);

}
