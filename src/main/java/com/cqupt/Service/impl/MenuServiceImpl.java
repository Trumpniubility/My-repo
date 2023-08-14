package com.cqupt.Service.impl;

import com.cqupt.Service.MenuService;
import com.cqupt.pojo.Entity.Menu;
import com.cqupt.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listByUserId(Integer userId) {
        List<Menu> menus = menuMapper.selectByUserId(userId);
        return menus;
    }
}
