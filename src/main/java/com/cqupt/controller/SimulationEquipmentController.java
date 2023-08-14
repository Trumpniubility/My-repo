package com.cqupt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.Service.SimulationEquipmentService;
import com.cqupt.pojo.DTO.PageMesDTO;
import com.cqupt.pojo.DTO.SimulationEquipmentDTO;
import com.cqupt.pojo.VO.PageResult;
import com.cqupt.pojo.VO.Result;
import com.cqupt.pojo.Entity.SimulationEquipment;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/SimulationEquipment")
public class SimulationEquipmentController {
    @Autowired
    private SimulationEquipmentService simulationEquipmentService;

    //添加
    @PostMapping
    public Result addSE(@RequestBody SimulationEquipment simulationEquipment) {
        log.info("仿真设备信息{}", simulationEquipment);
        boolean result = simulationEquipmentService.save(simulationEquipment);

        if (!result) {
            return Result.error("添加失败");
        }

        return Result.success("添加成功");
    }

    //删除
    @DeleteMapping("/{id}")
    public Result deleteSE(@PathVariable int id) {
        boolean b = simulationEquipmentService.removeById(id);

        if (!b) {
            return Result.error("删除失败");
        }

        return Result.success("删除成功");
    }

    //修改
    @PutMapping
    public Result updateSE(@RequestBody SimulationEquipment simulationEquipment) {
        simulationEquipment.setUpdateTime(LocalDateTime.now());
        log.info("仿真设备{}", simulationEquipment);
        boolean result = simulationEquipmentService.updateById(simulationEquipment);
        if (!result) {
            return Result.error("修改失败");
        }

        return Result.success("修改成功");
    }

    @ApiOperation("直接展示所有设备信息")
    @GetMapping
    public Result selectSE() {
        List<SimulationEquipment> list = simulationEquipmentService.list();
        System.out.println(list);
        return Result.success(list);
    }

    @GetMapping("/page")
    @ApiOperation("分页查询，查询全部仿真设备信息进行分页")
    public Result selectSEByCondition(@RequestBody PageMesDTO pageMesDTO) {
        Page<SimulationEquipment> page = new Page<>(pageMesDTO.getPage(), pageMesDTO.getPageSize());

        //分页
        List<SimulationEquipment> simulationEquipments = simulationEquipmentService.listPage(page);
        log.info("查询结果{}",simulationEquipments);

        //获取总记录数和查询结果
        long total = page.getTotal();
        log.info("当前页总记录数{}",total);
        List<SimulationEquipment> records = page.getRecords();

        PageResult pageResult =new PageResult(total,records);

        return Result.success(pageResult);
    }

    //TODO 可以改成普通的条件查询，亦可以为分页查询，现在为普通条件查询
    @ApiOperation("根据编号、名字使用模糊查询")
    @GetMapping("/Condition")
    public Result selectByIdAnd(@RequestBody SimulationEquipmentDTO simulationEquipmentDTO){
        log.info("查询条件为{}",simulationEquipmentDTO);

        //设置条件
        QueryWrapper<SimulationEquipment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("number",simulationEquipmentDTO.getNumber())
                .or()
                .like("name",simulationEquipmentDTO.getName());

        List<SimulationEquipment> list = simulationEquipmentService.list(queryWrapper);
        long total = list.size();

        return Result.success(new PageResult(total,list));
    }

//    TODO 导入仿真设备Excel暂未实现
   /* @GetMapping(value = "/exportSimulationEquipmentData")
    public void exportSimulationEquipmentData( HttpServletResponse response) throws Exception {
        List<SimulationEquipment> list = seService.selectSimulationEquipmentList();
        // 创建Excel文档
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("仿真设备信息","仿真设备信息"),
                SimulationEquipment.class, list);

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" +
                URLEncoder.encode("SimulationEquipment.xlsx", "UTF-8"));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        workbook.write(response.getOutputStream());
    }*/
}
