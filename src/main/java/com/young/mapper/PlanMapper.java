package com.young.mapper;

import com.young.entity.PlanEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PlanMapper {

    @Select("SELECT * FROM plan WHERE del=0")
    @Results({
            @Result(property = "planId",  column = "plan_id"),
            @Result(property = "name",  column = "pname"),
            @Result(property = "callLimit",  column = "climit"),
            @Result(property = "callCost",  column = "ccost"),
            @Result(property = "msgLimit",  column = "mlimit"),
            @Result(property = "msgCost",  column = "mcost"),
            @Result(property = "localFlowLimit",  column = "llimit"),
            @Result(property = "localFlowCost",  column = "lcost"),
            @Result(property = "allCountryFlowLimit",  column = "alimit"),
            @Result(property = "allCountryFlowCost",  column = "acost")
    })
    List<PlanEntity> getAll();

    @Select("SELECT * FROM plan WHERE plan_id = #{0}")
    @Results({
            @Result(property = "planId", column = "plan_id"),
            @Result(property = "name",  column = "pname"),
            @Result(property = "callLimit",  column = "climit"),
            @Result(property = "callCost",  column = "ccost"),
            @Result(property = "msgLimit",  column = "mlimit"),
            @Result(property = "msgCost",  column = "mcost"),
            @Result(property = "localFlowLimit",  column = "llimit"),
            @Result(property = "localFlowCost",  column = "lcost"),
            @Result(property = "allCountryFlowLimit",  column = "alimit"),
            @Result(property = "allCountryFlowCost",  column = "acost")
    })
    PlanEntity getOne(int planId);

    @Insert("INSERT INTO plan(cost,pname,intro,climit,ccost,mlimit,mcost,llimit,lcost,alimit,acost) VALUES(#{cost}, #{name}, #{intro}, #{callLimit}, #{callCost}, #{msgLimit}, #{msgCost}, #{localFlowLimit}, #{localFlowCost}, #{allCountryFlowLimit}, #{allCountryFlowCost})")
    @Options(useGeneratedKeys=true, keyProperty="planId", keyColumn="plan_id")
    void insert(PlanEntity planEntity);

}
