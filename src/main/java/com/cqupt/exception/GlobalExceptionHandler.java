package com.cqupt.exception;

import com.cqupt.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //所有的异常由全局异常处理器处理
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)  //捕获所有异常
    public Result ex(Exception e){
     e.printStackTrace();
     return Result.error("对不起，操作失败，请联系管理员");
    }
}
