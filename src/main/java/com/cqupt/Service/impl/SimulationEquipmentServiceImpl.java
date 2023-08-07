package com.cqupt.Service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.Service.SimulationEquipmentService;
import com.cqupt.entity.SimulationEquipment;
import com.cqupt.mapper.SimulationEquipmentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationEquipmentServiceImpl extends ServiceImpl<SimulationEquipmentMapper, SimulationEquipment> implements SimulationEquipmentService{
    @Autowired
    private SimulationEquipmentMapper simulationEquipmentMapper;

    @Override
    public List<SimulationEquipment> listPage(Page<SimulationEquipment> page) {
        QueryWrapper<SimulationEquipment> queryWrapper  =new QueryWrapper<>();
        //分页查询的自定义条件设置
        queryWrapper.like("name","设备");

        Page<SimulationEquipment> page1 = simulationEquipmentMapper.selectPage(page, null);
        List<SimulationEquipment> list = page1.getRecords();
        return list;
    }
}
