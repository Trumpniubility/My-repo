package com.cqupt.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.entity.Leave;

import java.util.List;

public interface LeaveService extends IService<Leave> {

    String checkLeave(Leave leave);
}
