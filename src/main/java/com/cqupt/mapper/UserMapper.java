package com.cqupt.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqupt.pojo.DTO.UserInfoDTO;
import com.cqupt.pojo.Entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //登陆中根据用户的账号密码信息，查询用户信息
    @Select("select user_id, account, create_time, email, intro, name, password, phone, type, update_time from user where account=#{account}")
    User selectByUser(User user);

    //存入注册用户的相关信息
    @Insert("insert into user(account,password,name,phone)" +
            " values(#{account},#{password},#{name},#{phone}) ")
    int insert(User user);

    //根据ID删除用户信息，即注销
    @Delete("delete from user where user_Id=#{userId} ")
    void deleteByUserId(Integer userId);

    //根据用户ID查找，用于判断是否存在该用户
   @Select("select * from user where user_Id=#{userId}")
    User selectByUserId(Integer userId);

   //根据账号查找用户
   @Select("select * from user where account=#{account}")
    User selectByAccount(String account);

   @Update("update user set account=#{account},name=#{name},email=#{email},phone=#{phone},intro=#{intro} where user_id=#{userId}")
    int updateUser(UserInfoDTO userInfoDTO);
}
