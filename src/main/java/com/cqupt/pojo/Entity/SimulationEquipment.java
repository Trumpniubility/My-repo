package com.cqupt.pojo.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("simulationequipment")
public class SimulationEquipment {

  @ExcelProperty("主键")
  @TableId(value = "simulation_equipment_id", type = IdType.AUTO)
  private int simulationEquipmentId;

  @ExcelProperty("")
  private String name;

  @ExcelProperty("编号")
  private String number;

  @ExcelProperty("类型")
  private int type;

  @ExcelProperty("设备系统")
  @TableField("software_system")
  private String softwareSystem;

  @ExcelProperty("版本号")
  @TableField("version_number")
  private String versionNumber;

  @ExcelProperty("供应方")
  private String supplier;

  @ExcelProperty("状态")
  private int status;

  @ExcelProperty("用途")
  private String purpose;

  @ExcelProperty("实验室ID")
  @TableField("lab_id")
  private int labId;

  @ExcelProperty("描述")
  @TableField("equipment_desc")
  private String equipmentDesc;

  @ExcelProperty("创建时间")
  @TableField("create_time")
  private LocalDateTime createTime;

  @ExcelProperty("更新时间")
  @TableField("update_time")
  private LocalDateTime updateTime;
}