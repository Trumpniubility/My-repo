package com.cqupt.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.Service.LeaveService;
import com.cqupt.pojo.Entity.Leave;
import com.cqupt.mapper.LeaveMapper;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {

    @Override
    public String checkLeave(Leave leave) {
        //校验学生请假信息
        return null;
    }
}
