package com.cqupt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cqupt.Service.UserService;
import com.cqupt.pojo.DTO.UserRegisterDTO;
import com.cqupt.pojo.VO.Result;
import com.cqupt.pojo.Entity.User;
import com.cqupt.utils.CaptchaUtils;
import com.cqupt.utils.SMSUtils;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO, HttpSession session){
        log.info("用户输入相关信息下{}",userRegisterDTO);

        //获取session中的验证码信息
        String code = (String)session.getAttribute("phone");

        //获取用户输入的验证码
        String userCode = userRegisterDTO.getCode();

        //非空判断和校验信息
        if(code!=null && !userCode.equals(code)){
            return Result.error("验证码错误，请重新输入");
        }

        //校验用户相关信息
        String checkResult= userService.check(userRegisterDTO);
        if(checkResult!=null){
            return Result.error(300,checkResult);
        }

        //进行注册，存入用户信息
        Boolean result = userService.add(userRegisterDTO);
        if(result){
            return Result.error("注册失败");
        }

        //确认是新用户且校验成功，返回前端成功注册信息
        return Result.success("注册成功");
    }

    @PostMapping("/sendMsg")
    public Result sendMsg(@RequestBody User user, HttpSession session){
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
            //生成验证码
            String code = CaptchaUtils.generateRandomCode(6);

            //发送短信
            SMSUtils.sendMessage("cquptfan","SMS_462570807",phone,code);

            session.setAttribute(phone,code);

            return Result.success("手机验证码短信发送成功");
        }

        return Result.error("短信发送失败");
    }
}
