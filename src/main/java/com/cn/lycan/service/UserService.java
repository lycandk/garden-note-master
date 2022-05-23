package com.cn.lycan.service;

import com.cn.lycan.entity.User;
import com.cn.lycan.mapper.UserMapper;
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
public class UserService {
    @Autowired
    UserMapper userMapper;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    public User getByName(String userName){
        return userMapper.findByUserName(userName);
    }

    public User get(String userName, String passWord){
        System.err.println("UserService get(): 尝试登录:"+" "+"账户："+userName+" "+"密码："+passWord);
        return userMapper.getByUserNameAndPassword(userName,passWord);
    }

    public void add(User user) {
        userMapper.add(user);
    }
}
