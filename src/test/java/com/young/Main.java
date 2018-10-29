package com.young;

import com.young.entity.*;
import com.young.mapper.*;
import org.apache.ibatis.binding.BindingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Main {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private PlanCallMapper planCallMapper;
    @Autowired
    private PlanMsgMapper planMsgMapper;
    @Autowired
    private PlanLocalFlowMapper planLocalFlowMapper;
    @Autowired
    private PlanAllCountryFlowMapper planAllCountryFlowMapper;
    @Autowired
    private UserPlanMapper userPlanMapper;
    @Autowired
    private UserCallRecordMapper userCallRecordMapper;
    @Autowired
    private UserMsgRecordMapper userMsgRecordMapper;
    @Autowired
    private UserLocalFlowRecordMapper userLocalFlowRecordMapper;
    @Autowired
    private UserAllCountryFlowRecordMapper userAllCountryFlowRecordMapper;
    @Autowired
    private UserPlanRecordMapper userPlanRecordMapper;

    /**
     * 系统操作
     */
    //增加新用户
    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new UserEntity("张龙"));
        userMapper.insert(new UserEntity("周一"));
        userMapper.insert(new UserEntity("袁玲"));
        userMapper.insert(new UserEntity("张鹏"));
        userMapper.insert(new UserEntity("赵雍"));
        userMapper.insert(new UserEntity("马超"));
        userMapper.insert(new UserEntity("董卓"));
        userMapper.insert(new UserEntity("留白"));
        userMapper.insert(new UserEntity("邓艾"));
        userMapper.insert(new UserEntity("钟会"));
        userMapper.insert(new UserEntity("马梦琪"));
        userMapper.insert(new UserEntity("刘伯温"));
        userMapper.insert(new UserEntity("韩信"));
        userMapper.insert(new UserEntity("王朗"));
        userMapper.insert(new UserEntity("刘表"));
        userMapper.insert(new UserEntity("鹏举"));
        userMapper.insert(new UserEntity("牛莉"));
        userMapper.insert(new UserEntity("海瑞"));
        userMapper.insert(new UserEntity("张之洞"));
        userMapper.insert(new UserEntity("高进"));
        userMapper.insert(new UserEntity("高海宇"));
    }

    //增加新套餐
    @Test
    public void testAddNewPlan() throws Exception {
        PlanEntity planEntity1 = new PlanEntity(20.0, "话费套餐", "月功能费20元，最多可拨打100分钟电话，超出时间按照0.5元/分钟计费。", 100, 0.5, -1, 0, -1, 0,-1 ,0);
        PlanEntity planEntity2 = new PlanEntity(10.0, "短信套餐", "月功能费10元，最多可发送200条短信，超出条数按0.1元/条计费。", -1, 0, 200, 0.1, -1, 0,-1 ,0);
        PlanEntity planEntity3 = new PlanEntity(20.0, "本地流量套餐", "月功能费20元，最多可获得2G流量，仅在本地使用，超出流量按3元/M计费。", -1, 0, -1, 0, 2048, 3,-1,0);
        PlanEntity planEntity4 = new PlanEntity(30.0, "国内流量套餐", "月功能费30元，最多可获得2G流量，超出流量按3元/M计费。", -1, 0, -1, 0, -1, 0,2048 ,3);
        planMapper.insert(planEntity1);
        planMapper.insert(planEntity2);
        planMapper.insert(planEntity3);
        planMapper.insert(planEntity4);
    }


    /**
     * 用户操作
     */
    //用户获取 所有套餐列表
    @Test
    public void testGetAllPlanInfo() throws Exception {
        List<PlanEntity> plans = planMapper.getAll();
        System.out.println(plans.toString());
    }

    //用户 购买套餐 立即生效
    @Test
    public void testBuyPlan() throws Exception {
        int userId = 1;
        int planId = 1;

        //默认可以重复购买一种套餐，套餐内容可叠加
        UserPlanEntity userPlanEntity = new UserPlanEntity(userId, planId);
        userPlanMapper.insert(userPlanEntity);
        //写入记录
        UserPlanRecordEntity userPlanRecordEntity = new UserPlanRecordEntity(userId, planId, "BUY");
        userPlanRecordMapper.insert(userPlanRecordEntity);
    }

    //用户 取消套餐 立即生效
    @Test
    public void testCancelNow() throws Exception {
        int userId = 1;
        int planId = 1;

        userPlanMapper.del(userId, planId);
        UserPlanRecordEntity userPlanRecordEntity = new UserPlanRecordEntity(userId, planId, "CANCEL");
        userPlanRecordMapper.insert(userPlanRecordEntity);
    }

    //用户 取消套餐 下个月才生效
    @Test
    public void testCancelNextMonth() throws Exception {
        int userId = 1;
        int planId = 2;

        userPlanMapper.notKeep(userId, planId);
        UserPlanRecordEntity userPlanRecordEntity = new UserPlanRecordEntity(userId, planId, "CANCEL NEXT MONTH");
        userPlanRecordMapper.insert(userPlanRecordEntity);
    }

    //用户查看 自己当月 套餐列表
    @Test
    public void testCheckPlanThisMonth() throws Exception {
        int userId = 1;

        List<PlanEntity> plans = userPlanMapper.getUserPlanList(userId);
        System.out.println("----------\n" + plans.toString() + "\n----------");
    }

    //用户查看 自己下个月 套餐列表
    @Test
    public void testCheckPlanNextMonth() throws Exception {
        int userId = 1;

        List<PlanEntity> keepPlans = userPlanMapper.getUserPlanKeepList(userId);
        System.out.println("----------\n" + "下个月的套餐：" + keepPlans.toString() + "\n----------");
    }

    //用户查看 自己当月套餐 叠加后 各类资费标准
    @Test
    public void testCheckPlanTogetherInfo() throws Exception {
        int userId = 1;

        List<PlanEntity> plans = userPlanMapper.getUserPlanList(userId);
        PlanEntity plan = new PlanEntity(plans);
        System.out.println(plan.toString());
    }

    //用户查看 套餐 购买以及取消 的 历史记录
    @Test
    public void testCheckUserPlanRecord() throws Exception {
        int userId = 1;

        List<UserPlanRecordEntity> records = userPlanRecordMapper.getUserPlanRecordList(userId);
        System.out.println("----------\n" + "历史记录: " + records.toString()  + "\n----------");
    }


    /**
     * 用户消费操作
     */
    //用户通话
    @Test
    public void testUseCall() throws Exception {
        int userId = 1;
        int value = 10;

        userCallRecordMapper.insert(userId, value);
    }

    //用户发送短信
    @Test
    public void testUseMsg() throws Exception {
        int userId = 1;
        int value = 1;

        userMsgRecordMapper.insert(userId, value);
    }

    //用户使用本地流量
    @Test
    public void testUseLocalFlow() throws Exception {
        int userId = 1;
        int value = 128;

        userLocalFlowRecordMapper.insert(userId, value);
    }

    //用户使用全国流量
    @Test
    public void testUseAllCountryFlow() throws Exception {
        int userId = 1;
        int value = 128;

        userAllCountryFlowRecordMapper.insert(userId, value);
    }


    /**
     * 用户查询消费详情操作
     */
    //用户查看当月通话总时长
    @Test
    public void testCheckCallSumTime() throws Exception {
        int userId = 1;

        try {
            int sumValue = userCallRecordMapper.getSumValue(userId);
            System.out.println("----------\n" + "用户通话总时长:" + sumValue + "min" + "\n----------");
        } catch (BindingException e) {
            System.out.println("----------\n" + "用户通话总时长:0min" + "\n----------");
        }
    }

    //用户查看当月发送短信总条数
    @Test
    public void testCheckMsgSumNum() throws Exception {
        int userId = 1;

        try {
            int sumValue = userMsgRecordMapper.getSumValue(userId);
            System.out.println("----------\n" + "用户发送短信总条数:" + sumValue + "条" + "\n----------");
        } catch (BindingException e) {
            System.out.println("----------\n" + "用户发送短信总条数:0条" + "\n----------");
        }
    }

    //用户查看已使用的本地流量
    @Test
    public void testCheckLocalFlowSumNum() throws Exception {
        int userId = 1;

        try {
            int sumValue = userLocalFlowRecordMapper.getSumValue(userId);
            System.out.println("----------\n" + "用户已使用本地流量:" + sumValue + "MB" + "\n----------");
        } catch (BindingException e) {
            System.out.println("----------\n" + "用户已使用本地流量:0MB" + "\n----------");
        }
    }

    //用户查看已使用的全国流量
    @Test
    public void testCheckAllCountryFlowSumNum() throws Exception {
        int userId = 1;

        try {
            int sumValue = userAllCountryFlowRecordMapper.getSumValue(userId);
            System.out.println("----------\n" + "用户已使用全国流量:" + sumValue + "MB" + "\n----------");
        } catch (BindingException e) {
            System.out.println("----------\n" + "用户已使用全国流量:0MB" + "\n----------");
        }
    }


    /**
     * 用户查询账单操作
     */
    //用户查看当月消费记录
    @Test
    public void testCheckConsumeHistory() throws Exception {
        int userId = 1;

        System.out.println("通话: \n" + userCallRecordMapper.getAll(userId).toString() + "\n");
        System.out.println("短信: \n" + userMsgRecordMapper.getAll(userId).toString() + "\n");
        System.out.println("本地流量: \n" + userLocalFlowRecordMapper.getAll(userId).toString() + "\n");
        System.out.println("全国流量: \n" + userAllCountryFlowRecordMapper.getAll(userId).toString() + "\n");
    }

    //用户查看当月消费总资费
    @Test
    public void testCheckConsumeBill() throws Exception {
        int userId = 1;

        PlanEntity plan = new PlanEntity(userPlanMapper.getUserPlanList(userId));
        int callValue = 0, msgValue = 0, localFlowValue = 0, allCountryFlowValue = 0;
        try { callValue = userCallRecordMapper.getSumValue(userId); } catch (BindingException e) { callValue = 0; }
        try { msgValue = userMsgRecordMapper.getSumValue(userId); } catch (BindingException e) { msgValue = 0; }
        try { localFlowValue = userLocalFlowRecordMapper.getSumValue(userId); } catch (BindingException e) { localFlowValue = 0; }
        try { allCountryFlowValue = userAllCountryFlowRecordMapper.getSumValue(userId); } catch (BindingException e) { allCountryFlowValue = 0; }
        BillEntity billEntity = new BillEntity(plan, callValue, msgValue, localFlowValue, allCountryFlowValue);
        System.out.println("---套餐内---");
        System.out.println("套餐总资费: " + billEntity.getPlanCost());
        System.out.println("---套餐外---");
        System.out.println("通话总资费: " + billEntity.getBillCallCost());
        System.out.println("短信总资费: " + billEntity.getBillMsgCost());
        System.out.println("本地流量总资费: " + billEntity.getBillLocalFlowCost());
        System.out.println("国内流量总资费: " + billEntity.getBillAllCountryFlowCost());
        System.out.println("---合计资费---");
        System.out.println("合计: " + billEntity.getBillCost());
    }

}
