package com.young.mapper;

import com.young.entity.consumeRecordEntity.MsgRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMsgRecordMapper {

    @Select("SELECT * FROM user_msg_record WHERE user_id = #{0}")
    List<MsgRecordEntity> getAll(int userId);

    @Select("SELECT SUM(value) FROM user_msg_record WHERE user_id = #{0}")
    int getSumValue(int userId);

    @Insert("INSERT INTO user_msg_record(user_id,value) VALUES(#{0},#{1})")
    void insert(int userId, int value);

}
