package com.young.logic;

import com.young.entity.PlanEntity;
import com.young.mapper.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PlanTest {

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

}
