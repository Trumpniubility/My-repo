package com.cqupt.Service;

import com.cqupt.entity.Menu;

import java.util.List;

public interface MenuService {
  List<Menu> listByUserId(Integer userId);
}
