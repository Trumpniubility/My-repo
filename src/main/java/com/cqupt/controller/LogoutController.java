package com.cqupt.controller;

import com.cqupt.Service.UserService;
import com.cqupt.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogoutController {
    @Autowired
    private UserService userService;

    //根据传来的ID删除用户信息
    @PostMapping("/user/logout/{userId}")
    public Result logout(@PathVariable Integer userId){
        log.info("注销用户ID{}",userId);

        //判断删除用户信息是否成功
        Boolean judge = userService.delete(userId);
        if(!judge){
            return Result.error(300,"不存在该用户");
        }
        return Result.success("注销成功");
    }

}
