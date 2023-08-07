package com.cqupt.entity;

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

  @TableId(value = "simulation_equipemt_id",type = IdType.AUTO)
  private int SimulationEquipmentId;

  private String name;
  private String number;
  private int type;

  @TableField("software_system")
  private String softwareSystem;

  @TableField("version_number")
  private String versionNumber;

  private String supplier;
  private int status;
  private String purpose;

  @TableField("lab_id")
  private int labId;

  private String thumbnail;

  @TableField("create_time")
  private LocalDateTime createTime;

  @TableField("update_time")
  private LocalDateTime updateTime;


}
