package com.cqupt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private static final long serialVersionUID = 1L;
    private int menuId;      // 菜单主键id
    private String cname;    // 中文名称
    private String ename;    // 英文名称
    private String path;     // 接口路径
    private String component; // 页面路径
    private String icon;      // 菜单图标
    private int pid;          //父菜单id
    private int sort;         //排序
    private Date createDate;  //创建时间
    private Date updateDate;   //修改时间
}
