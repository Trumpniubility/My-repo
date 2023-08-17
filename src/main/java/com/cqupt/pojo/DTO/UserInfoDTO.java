package com.cqupt.pojo.DTO;

import lombok.Data;

@Data
public class UserInfoDTO {
    private Integer userId;
    private String account; //账号
    private String name;
    private String email;
    private String phone;
    private String intro;
}
