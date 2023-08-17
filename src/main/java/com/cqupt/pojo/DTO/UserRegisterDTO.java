package com.cqupt.pojo.DTO;

import com.cqupt.pojo.Entity.User;
import lombok.Data;

@Data
public class UserRegisterDTO extends User {
    private String code;
}
