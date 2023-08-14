package com.cqupt.Service.impl;

import com.cqupt.Service.DictionaryService;
import com.cqupt.pojo.Entity.Dictionary;
import com.cqupt.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> listByTypeAndPid(String typeCode, Integer pid) {
       List<Dictionary> list = dictionaryMapper.selectByTypeAndPid(typeCode,pid);
//        for (Dictionary dictionary : list) {
//            Date currentDate=new Date();
//            dictionary.setUpdate_time(currentDate);
//        }  可有可无，设置更新表单日期
        return list;
    }
}
