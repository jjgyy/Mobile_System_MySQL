package com.young.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.young.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("SELECT * FROM user WHERE del = 0")
    @Results({
            @Result(property = "userId", column = "user_id")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    @Results({
            @Result(property = "userId", column = "user_id")
    })
    UserEntity getOne(int userId);

    @Insert("INSERT INTO user(uname) VALUES(#{name})")
    @Options(useGeneratedKeys=true, keyProperty="userId", keyColumn="user_id")
    void insert(UserEntity user);

    @Update("UPDATE user SET name=#{uname} WHERE user_id =#{userId}")
    void update(UserEntity user);

    @Delete("DELETE FROM user WHERE user_id =#{userId}")
    void delete(int userId);

}