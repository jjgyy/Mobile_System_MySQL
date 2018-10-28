package com.young.mapper;

import com.young.entity.PlanEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanMapperTest {

    @Autowired
    private PlanMapper PlanMapper;

    @Test
    public void testQuery() throws Exception {
        List<PlanEntity> plans = PlanMapper.getAll();
        System.out.println(plans.toString());
    }

}
