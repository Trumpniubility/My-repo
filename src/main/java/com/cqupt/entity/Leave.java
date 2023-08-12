package com.cqupt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.util.Date;

@Data
@TableName("leaveinfo")
public class Leave {
    //请假id
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "请假编号")
    @TableField(value = "leave_id")
    private String leaveId;

    @ApiModelProperty(value = "请假理由")
    private String reason;

    @ApiModelProperty(value = "天数")
    @TableField(value = "day_num")
    private int dayNum;

    @ApiModelProperty(value = "学号")
    @TableField(value = "stu_no")
    private String stuNo;

    @ApiModelProperty(value = "姓名")
    @TableField(value = "stu_name")
    private String stuName;

    @ApiModelProperty(value = "请假时间")
    @TableField(value = "apply_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;

    @ApiModelProperty(value = "状态")
    private int status;

    @ApiModelProperty(value = "审核时间")
    @TableField(value = "audit_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date auditTime;

    @ApiModelProperty(value = "审核意见")
    private String opinion;

    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
