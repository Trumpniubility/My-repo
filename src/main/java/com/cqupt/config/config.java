package com.cqupt.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cqupt.mapper")
public class config {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor Interceptor = new MybatisPlusInterceptor();
        //添加分页查询插件
        Interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return Interceptor;
    }
}
