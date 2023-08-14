package com.cqupt.controller;


import com.cqupt.Service.UserService;
import com.cqupt.pojo.VO.Result;
import com.cqupt.pojo.Entity.User;
import com.cqupt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public Result getUserMes(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        log.info("令牌{}",token);

        Claims claims = JwtUtils.parseJwt(token);
        log.info("获取到用户信息{}",claims);

//        String name = claims.get("Name", String.class);
//        String password = claims.get("password", String.class);
//        String intro = claims.get("intro", String.class);
//        String email = claims.get("email", String.class);
//        String phone = claims.get("phone", String.class);
//        log.info("获取得到信息{}{}{}{}{}",name,password,intro,email,phone);

       //封装到用户类中
//        User userMes = new User();
//        userMes.setName(name);
//        userMes.setPassword(password);
//        userMes.setIntro(intro);
//        userMes.setEmail(email);
//        userMes.setPhone(phone);


        return Result.success(claims);
    }

    //判断用户是否存在
    @PostMapping("/isExisting/{account}")
    public Result UserIsExist(@PathVariable String account){
       User user = new User();
       user.setAccount(account);

       log.info("用户信息{}",account);
       if(userService.select(user)==null){
           return Result.error(300,"用户不存在");
       }

        return Result.success();
    }

    //查看仿真设备详细信息

}
