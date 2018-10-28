package com.young.logic;

import com.young.entity.PlanEntity;
import com.young.entity.UserEntity;
import com.young.entity.UserPlanRecordEntity;
import com.young.mapper.PlanMapper;
import com.young.mapper.UserMapper;
import com.young.mapper.UserPlanRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserOperatePlan {

    private UserEntity user;
    private PlanEntity plan;

    @Autowired
    private UserMapper UserMapper;
    @Autowired
    private PlanMapper PlanMapper;
    @Autowired
    private UserPlanRecordMapper UserPlanRecordMapper;

    public UserOperatePlan(UserEntity user, PlanEntity plan) {
        this.user = user;
        this.plan = plan;
    }

    public UserOperatePlan(int userId, int planId) {
        this.user = UserMapper.getOne(userId);
        this.plan = PlanMapper.getOne(planId);
    }

    public void buy() {
        UserPlanRecordEntity userPlanRecordEntity = new UserPlanRecordEntity(user.getUserId(), plan.getPlanId(), "BUY");
        UserPlanRecordMapper.insert(userPlanRecordEntity);
    }

}
