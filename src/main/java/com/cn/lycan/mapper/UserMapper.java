package com.cn.lycan.mapper;

import com.cn.lycan.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author Makkapakka
 * @date 2022-5-13
 * @package_name com.cn.lycan.mapper
 * @description
 */
@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{userName}")
    public User findByUserName(String userName);
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    public User getByUserNameAndPassword(@Param("username") String userName, @Param("password") String  passWord);

    @Insert("INSERT INTO user (username,password,salt) VALUES (#{username},#{password},#{salt})")
    void add(User user);
}
