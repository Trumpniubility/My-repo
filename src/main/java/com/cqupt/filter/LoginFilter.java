package com.cqupt.filter;

import com.alibaba.fastjson.JSONObject;
import com.cqupt.entity.Result;
import com.cqupt.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response =(HttpServletResponse)servletResponse;

        //接收请求 完整URL：协议+IP+端口+请求路径
        String url = request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
        log.info("请求的url是{}",url);

        //判断是否是登陆请求。如果是直接放行
        if(url.contains("login")){
            log.info("登陆操作，放行->");
            filterChain.doFilter(request,response);
            return;
        }

        //获取请求头中的token
        String jwt= request.getHeader("token");
        log.info("获取到令牌{}",jwt);

        //判断令牌是否存在，不存在返回错误信息
         if(!StringUtils.hasLength(jwt)){
             log.info("请求头token为空，返回未登陆的信息");
             Result error = Result.error("未登陆！");

             //手动将对象转为json格式的字符串  fastjson工具类->阿里巴巴提供的工具类，需要引入相关依赖
             String notlogin = JSONObject.toJSONString(error);

             //返回给浏览器信息
             response.getWriter().write(notlogin);
             return;
         }

        //解析token，如果解析失败，否则返回错误信息
        try {
           JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败,返回未登陆的错误信息");
            Result error = Result.error("未登陆");

            //手动将对象转为json格式的字符串  fastjson工具类->阿里巴巴提供的工具类，需要引入相关依赖
            String notLogin = JSONObject.toJSONString(error);

            //返回给浏览器信息
            response.getWriter().write(notLogin);
            return;
        }

        //放行
        log.info("令牌合法");
        filterChain.doFilter(request,response);

    }
}
