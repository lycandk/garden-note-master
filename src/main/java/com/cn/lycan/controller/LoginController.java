package com.cn.lycan.controller;

import com.cn.lycan.entity.Result;
import com.cn.lycan.entity.User;
import com.cn.lycan.result.ResultFactory;
import com.cn.lycan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

/**
 * @author Makkapakka
 * @date 2022-5-13
 * @package_name com.cn.lycan.controller
 * @description
 */
@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User requestUser) {

        // 对 html 标签进行转义，防止 XSS 攻击
        String userName = requestUser.getUsername();
        userName = HtmlUtils.htmlEscape(userName);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,requestUser.getPassword());
        try{
            subject.login(usernamePasswordToken);
//            User user = userService.get(userName,requestUser.getPassword());
//            httpSession.setAttribute("user",user);
            return ResultFactory.buildSuccessResult(userName);
        }catch (AuthenticationException e){
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
//        if (user==null){
//            String Message = "账号或密码错误！";
//            System.out.println(Message);
//            return new Result(400);
//        }
//        else {
//            System.err.println("账户："+userName+" "+"密码："+requestUser.getPassword());
//            httpSession.setAttribute("user",user);
//            return new Result(200);
//        }
    }

    @GetMapping("api/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }
}
