package com.cqupt.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.Service.LeaveService;
import com.cqupt.entity.Leave;
import com.cqupt.mapper.LeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {

    @Override
    public String checkLeave(Leave leave) {
        //校验学生请假信息
        return null;
    }
}
