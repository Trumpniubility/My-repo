package com.cqupt.mapper;

import com.cqupt.entity.Menu;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface MenuMapper {
    List<Menu> selectByUserId(Integer userId);
}
