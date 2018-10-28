package com.young.mapper;

import com.young.entity.PlanEntity;
import com.young.entity.UserPlanEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserPlanMapper {

    @Select("SELECT * FROM plan JOIN user_plan ON plan.plan_id=user_plan.plan_id WHERE user_id=#{0} AND user_plan.del=0")
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
    List<PlanEntity> getUserPlanList(int userId);

    @Select("SELECT * FROM plan JOIN user_plan ON plan.plan_id=user_plan.plan_id WHERE user_id=#{0} AND user_plan.keep=1 AND user_plan.del=0")
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
    List<PlanEntity> getUserPlanKeepList(int userId);

    @Insert("INSERT INTO user_plan(user_id, plan_id) VALUES(#{userId}, #{planId})")
    void insert(UserPlanEntity userPlan);

    @Update("UPDATE user_plan SET keep=0 WHERE user_id =#{0} AND plan_id =#{1}")
    void notKeep(int userId, int planId);

    @Update("UPDATE user_plan SET del=1 WHERE user_id =#{0} AND plan_id =#{1}")
    void del(int userId, int planId);

}
