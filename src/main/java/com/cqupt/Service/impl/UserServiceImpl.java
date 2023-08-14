package com.cqupt.Service.impl;

import com.cqupt.Service.UserService;
import com.cqupt.pojo.Entity.User;
import com.cqupt.mapper.UserMapper;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //添加用户数据
    @Override
    public void add(User user) {
        //全部校验无误，调用方法存入数据库
        userMapper.insert(user);
    }

    //查询是否存在该用户
    @Override
    public User select(User user) {
        //调用selectByUser方法查询该用户，先判断是否存在该用户如果没有会返回null
        User user1 = userMapper.selectByAccount(user.getAccount());

        if(user1==null){
            return null;
        }

        log.info("查询出的用户信息{}",user1);
        return user1;
    }

    @Override
    public Boolean delete(Integer userId) {
        //根据userID查询用户是否存在
        User user = userMapper.selectByUserId(userId);
        if(user ==null){
            return false;
        }

        //存在就执行删除操作
        userMapper.deleteByUserId(userId);
        return true;
    }

    @Override
    public String check(User user) {
        //校验账号，手机号，不符合要求直接返回错误信息
        //密码 用户名暂时不做验证----
        log.info("校验用户{}",user);

        //非空判断先
        if(StringUtils.isBlank(user.getAccount()) ||
                StringUtils.isBlank(user.getPhone()) ||
                StringUtils.isBlank(user.getPassword()) ||
                StringUtils.isBlank(user.getName())
        ){
            return "信息请输入完整！";
        }

        //验证账号
        if(userMapper.selectByAccount(user.getAccount())!=null){
            log.info("验证账号结果{}",userMapper.selectByAccount(user.getAccount())!=null);
            return "账号已注册！";
        }
        // 验证手机号
        String regex = "1[3-9]\\d{9}";
        boolean res = user.getPhone().matches(regex);
        //如果手机号格式不对返回错误信息
        if(!res){
            return "手机号格式错误！请重新输入";
        }

        //校验成功则不用返回任何信息
        return null;
    }


}
