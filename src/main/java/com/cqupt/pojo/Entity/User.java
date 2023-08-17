package com.cqupt.pojo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;
    private Integer TeacherId;
    private Integer studentId;
    private Integer clazzId;
    private Integer experiments;
    private Integer type;  //1表示教师 2代表学生
    private String account; //账号
    private String password;
    private String name;
    private String number;
    private String phone;
    private String email;
    private String intro;
    private LocalDate createTime;
    private LocalDate updateTime;

}
