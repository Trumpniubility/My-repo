package com.cqupt.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.Entity.SimulationEquipment;

import java.util.List;

public interface SimulationEquipmentService extends IService<SimulationEquipment> {
    List<SimulationEquipment> listPage(Page<SimulationEquipment> page);
}
