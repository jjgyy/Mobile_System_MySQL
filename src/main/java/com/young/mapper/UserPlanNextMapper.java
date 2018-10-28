package com.young.mapper;

import com.young.entity.PlanEntity;
import com.young.entity.UserPlanEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserPlanNextMapper {

    @Select("SELECT * FROM plan JOIN user_plan_next ON plan.plan_id=user_plan_next.plan_id WHERE user_id=#{0} AND user_plan_next.del=0")
    @Results({
            @Result(property = "planId",  column = "plan_id"),
    })
    List<PlanEntity> getUserPlanNextList(int userId);

    @Insert("INSERT INTO user_plan_next(user_id, plan_id) VALUES(#{userId}, #{planId})")
    void insert(UserPlanEntity userPlan);

}
