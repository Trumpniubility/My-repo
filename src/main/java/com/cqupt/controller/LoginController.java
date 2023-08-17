package com.cqupt.controller;

import com.cqupt.Service.MenuService;
import com.cqupt.Service.UserService;
import com.cqupt.pojo.VO.Result;
import com.cqupt.pojo.Entity.User;
import com.cqupt.utils.JwtUtils;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j //可以输出日志
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用户登陆{}", user);
        User user1 = userService.select(user);
        //对user1判断，如果返回的信息为null,表示该用户并未登陆，不是null表示登陆成功下发令牌
        if (user1 != null) {
            //自己定义想要传的值到令牌中
            Map<String, Object> claims = new HashMap<>();
            claims.put("userID",user1.getUserId());
            claims.put("account",user1.getAccount());
            claims.put("email", user1.getEmail());
            claims.put("Name", user1.getName());
            claims.put("phone", user1.getPhone());
            claims.put("intro", user1.getIntro());
            log.info("用户信息{}", claims);
            //调用工具类中方法生成令牌
            //令牌中就包括了当前用户的相关信息
            String jwt = JwtUtils.generateJwt(claims);
            log.info("令牌存入用户信息{}",claims);
            //定义集合储存令牌信息，菜单信息
            Map<String, Object> list = new HashMap<>();
            list.put("menu", menuService.listByUserId(user1.getUserId()));
            list.put("token", jwt);

            //返回给前端数据
            return Result.success("登陆成功",list);
        }

        //登录失败，返回错误信息
        return Result.error(300,"用户名或者密码错误");
    }
}
