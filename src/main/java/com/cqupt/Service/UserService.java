package com.cqupt.Service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.DTO.UserInfoDTO;
import com.cqupt.pojo.DTO.UserRegisterDTO;
import com.cqupt.pojo.Entity.User;

public interface UserService extends IService<User> {
    Boolean add(UserRegisterDTO user);

    User select(User user);

    Boolean delete(Integer userId);

    String check(User user);

    int updateUser(UserInfoDTO userInfoDTO);
}
