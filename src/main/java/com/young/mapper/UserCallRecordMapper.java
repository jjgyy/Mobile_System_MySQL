package com.young.mapper;

import com.young.entity.consumeRecordEntity.CallRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserCallRecordMapper {

    @Select("SELECT * FROM user_call_record WHERE user_id = #{0}")
    List<CallRecordEntity> getAll(int userId);

    @Select("SELECT SUM(value) FROM user_call_record WHERE user_id = #{0}")
    int getSumValue(int userId);

    @Insert("INSERT INTO user_call_record(user_id,value) VALUES(#{0},#{1})")
    void insert(int userId, int value);

}
