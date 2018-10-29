package com.young.mapper;

import com.young.entity.consumeRecordEntity.AllCountryFlowRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserAllCountryFlowRecordMapper {

    @Select("SELECT * FROM user_aflow_record WHERE user_id = #{0}")
    List<AllCountryFlowRecordEntity> getAll(int userId);

    @Select("SELECT SUM(value) FROM user_aflow_record WHERE user_id = #{0}")
    int getSumValue(int userId);

    @Insert("INSERT INTO user_aflow_record(user_id,value) VALUES(#{0},#{1})")
    void insert(int userId, int value);

}
