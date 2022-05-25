package com.cn.lycan.service;

import com.cn.lycan.entity.User;
import com.cn.lycan.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Makkapakka
 * @date 2022-5-13
 * @package_name com.cn.lycan.service
 * @description
 */
@Component
@Service
@Log4j2
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 判断是否存在用户
     * @param username
     * @return
     */
    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    /**
     * 通过用户名查找用户
     */
    public User getByName(String userName){
        return userMapper.findByUserName(userName);
    }

    /**
     * 通过用户名以及密码查找用户
     */
    public User get(String userName, String passWord){
        log.info("UserService get(): 尝试获取用户:"+" "+"账户："+userName+" "+"密码："+passWord);
        try{
            get(userName,passWord);
        }
        catch (RuntimeException e){
            log.info("UserService get(): 尝试获取用户:"+" "+"账户："+userName+" "+"密码："+passWord+" 发生错误！");
        }
        return userMapper.getByUserNameAndPassword(userName,passWord);
    }

    /**
     * 增加用户
     */
    public void add(User user) {
        userMapper.add(user);
    }
}
