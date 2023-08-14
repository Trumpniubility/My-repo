package com.cqupt.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.Entity.Leave;

public interface LeaveService extends IService<Leave> {

    String checkLeave(Leave leave);
}
