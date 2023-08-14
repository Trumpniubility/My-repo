package com.cqupt.mapper;

import com.cqupt.pojo.Entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictionaryMapper {
    @Select("select dicItemId,codeName,codeValue,typeCode,parentItemId from dictionary where parentItemId=#{pid} and typeCode=#{typeCode}")
    List<Dictionary> selectByTypeAndPid(String typeCode, Integer pid);
}
