package com.cqupt.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.Service.SimulationEquipmentService;
import com.cqupt.entity.Result;
import com.cqupt.entity.SimulationEquipment;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        boolean result = simulationEquipmentService.updateById(simulationEquipment);
        if (!result) {
            return Result.error("修改失败");
        }

        return Result.success("修改成功");
    }

    //查询所有
    @GetMapping
    public Result selectSE() {
        List<SimulationEquipment> list = simulationEquipmentService.list();
        System.out.println(list);
        return Result.success(list);
    }

    //分页查询
    @GetMapping("/page")
    public Result selectSEByCondition(Integer page, Integer pagesize) {
        Page<SimulationEquipment> page1 = new Page<>(page,pagesize);

        List<SimulationEquipment> list = simulationEquipmentService.listPage(page1);
        return Result.success(list);
    }

    //导入仿真设备暂未实现
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
