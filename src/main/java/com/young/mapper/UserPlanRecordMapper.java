package com.young.mapper;

import com.young.entity.UserPlanRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserPlanRecordMapper {

    @Select("SELECT * FROM user_plan_record JOIN plan ON plan.plan_id=user_plan_record.plan_id JOIN user ON user.user_id=user_plan_record.user_id WHERE user_plan_record.user_id=#{0}")
    @Results({
            @Result(property = "planRecordId",  column = "plan_record_id"),
            @Result(property = "userId",  column = "user_id"),
            @Result(property = "planId",  column = "plan_id"),
            @Result(property = "userName",  column = "uname"),
            @Result(property = "planName",  column = "pname"),
    })
    List<UserPlanRecordEntity> getUserPlanRecordList(int userId);

    @Insert("INSERT INTO user_plan_record(user_id, plan_id, type) VALUES ( #{userId}, #{planId}, #{type} ) ")
    void insert(UserPlanRecordEntity userPlanRecord);

}
