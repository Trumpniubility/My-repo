package com.cqupt.Service;

import com.cqupt.pojo.Entity.Menu;

import java.util.List;

public interface MenuService {
  List<Menu> listByUserId(Integer userId);
}
