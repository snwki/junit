package com.snwki.junit.mapper;

import com.snwki.junit.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where user_id = #{userId}")
    User getById(Integer userId);

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into user(user_name, password) values(#{userName},#{password})")
    Integer save(User user);
}
