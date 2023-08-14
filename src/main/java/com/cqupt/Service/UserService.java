package com.cqupt.Service;


import com.cqupt.pojo.Entity.User;

public interface UserService {
    void add(User user);

    User select(User user);

    Boolean delete(Integer userId);

    String check(User user);
}
