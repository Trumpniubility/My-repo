package com.cqupt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {
    private static final String signKey = "cqupt";
    private static final Long expire = 24*3600*1000L;

//      生成JWT令牌
//      @param claims JWT第二部分负载 payload 中存储的内容
        public static String generateJwt(Map<String,Object> claims){
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, signKey) //设置加密方式和密钥
                    .setExpiration(new Date(System.currentTimeMillis() + expire)) //设置令牌生效时间
                    .setClaims(claims) //设置令牌自定义内容
                    .compact();
            return jwt;
        }


//      解析JWT令牌
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody(); //成功获取到自定义内容
        System.out.println(claims);
        return claims;
    }


}
