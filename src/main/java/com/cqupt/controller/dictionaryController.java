package com.cqupt.controller;

import com.cqupt.Service.DictionaryService;
import com.cqupt.entity.Dictionary;
import com.cqupt.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@Slf4j
@RestController
public class dictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @PostMapping("/register/dictionary/{usertype}")
    public Result getType(@PathVariable String usertype ){
        log.info("根据类型查询菜单{}",usertype);
        List<Dictionary> list = dictionaryService.listByTypeAndPid(usertype,0);

        return Result.success(list);
    }
}
