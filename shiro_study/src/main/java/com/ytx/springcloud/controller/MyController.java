package com.ytx.springcloud.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("myController")
public class MyController {

    @GetMapping("userLogin")
    @ResponseBody
    public String userLogin(String name, String password) {
        //1.获取subject对象
        Subject subject = SecurityUtils.getSubject();
        //2.封装请求数据到token
        AuthenticationToken token = new UsernamePasswordToken(name, password);
        //3.调用login方法
        try {
            subject.login(token);
            return "登录成功";
        } catch (AuthenticationException e) {
            return "登录失败";
        }
    }
}
