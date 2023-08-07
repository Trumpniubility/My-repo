package com.cqupt.controller;

import com.cqupt.Service.UserService;
import com.cqupt.entity.Result;
import com.cqupt.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegisterController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("注册用户{}",user);


        //校验用户相关信息
        String checkResult= userService.check(user);
        if(checkResult!=null){
            return Result.error(300,checkResult);
        }

        //进行注册
        userService.add(user);

        //确认是新用户且校验成功，返回前端成功注册信息
        return Result.success("注册成功");
    }
}
