package com.young.logic;


import com.young.entity.PlanEntity;
import com.young.entity.UserPlanEntity;
import com.young.entity.UserPlanRecordEntity;
import com.young.mapper.PlanMapper;
import com.young.mapper.UserPlanMapper;
import com.young.mapper.UserPlanNextMapper;
import com.young.mapper.UserPlanRecordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOperatePlanTest {

    @Autowired
    private com.young.mapper.PlanMapper planMapper;
    @Autowired
    private UserPlanRecordMapper userPlanRecordMapper;
    @Autowired
    private UserPlanMapper userPlanMapper;
    @Autowired
    private UserPlanNextMapper userPlanNextMapper;

    //用户了解所有套餐
    @Test
    public void testGetAllPlanInfo() throws Exception {
        List<PlanEntity> plans = planMapper.getAll();
        System.out.println(plans.toString());
    }

    //用户购买套餐
    @Test
    public void testBuy() throws Exception {
        int userId = 1;
        int planId = 1;
        UserPlanEntity userPlanEntity = new UserPlanEntity(userId, planId);
        userPlanMapper.insert(userPlanEntity);
        UserPlanRecordEntity userPlanRecordEntity = new UserPlanRecordEntity(userId, planId, "BUY");
        userPlanRecordMapper.insert(userPlanRecordEntity);
    }

    //取消套餐立即生效
    @Test
    public void testCancelNow() throws Exception {
        int userId = 1;
        int planId = 1;
        userPlanMapper.del(userId, planId);
        UserPlanRecordEntity userPlanRecordEntity = new UserPlanRecordEntity(userId, planId, "CANCEL");
        userPlanRecordMapper.insert(userPlanRecordEntity);
    }

    //取消套餐下个月才生效
    @Test
    public void testCancelNextMonth() throws Exception {
        int userId = 1;
        int planId = 2;
        userPlanMapper.notKeep(userId, planId);
        UserPlanRecordEntity userPlanRecordEntity = new UserPlanRecordEntity(userId, planId, "CANCEL NEXT MONTH");
        userPlanRecordMapper.insert(userPlanRecordEntity);
    }

    //用户查看自己当月套餐列表
    @Test
    public void testCheckPlanThisMonth() throws Exception {
        int userId = 1;
        List<PlanEntity> plans = userPlanMapper.getUserPlanList(userId);
        System.out.println(plans.toString());
    }

    //用户查看自己下个月套餐列表
    @Test
    public void testCheckPlanNextMonth() throws Exception {
        int userId = 1;
        List<PlanEntity> keepPlans = userPlanMapper.getUserPlanKeepList(userId);
        System.out.println("保持到下个月的套餐：" + keepPlans.toString());
        List<PlanEntity> nextPlans = userPlanNextMapper.getUserPlanNextList(userId);
        System.out.println("下个月生效的套餐：" + nextPlans.toString());
    }

    //用户查看自己当月套餐叠加后各类资费标准
    @Test
    public void testCheckPlanTogetherInfo() throws Exception {
        int userId = 1;
        List<PlanEntity> plans = userPlanMapper.getUserPlanList(userId);
        PlanEntity plan = new PlanEntity(plans);
        System.out.println(plan.toString());
    }

    //用户查看历史记录
    @Test
    public void testCheckUserPlanRecord() throws Exception {
        int userId = 1;
        List<UserPlanRecordEntity> records = userPlanRecordMapper.getUserPlanRecordList(userId);
        System.out.println("历史记录：" + records.toString());
    }

    //下个月到来，月初调用该方法
    @Test
    public void testIntoNextMonth() throws Exception {

    }

}
