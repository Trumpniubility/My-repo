package com.cqupt.pojo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dictionary {
    private static final long serialVersionUID = 1L;
    private int dicItemId;       // 字典id
    private String codeName;        // 编码名称key
    private String codeValue;       // 编码值 value
    private Date creat_time;    // 创建时间
    private Date update_time;     // 更新时间
    private int isRanked;        // 排序
    private String typeCode;        // 类别名称
    private int parentItemId;    // 父id
    private String remark;          // 评论
    private int isDelete;        // 是否删除 0:删除 1:未删除

}
