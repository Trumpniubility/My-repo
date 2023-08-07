package com.cqupt;

import com.cqupt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
class VirtualSimulationTeachingSystemApplicationTests {

//    @Test
//    void contextLoads() {
//        Date currentDate =new Date();
//        System.out.println(currentDate);
//    }

//    @Test
//    void parseToken(){
//        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6ImFkbWluIiwicGhvbmUiOiIxNTIxNTAyOTY5MiIsInVzZXJJZCI6MSwidXNlcm5hbWUiOm51bGx9.wG0243eYd0Ed_MiAq0rhpJMlNAhaRB3GN1W_j4C0zsA";
//        Claims claims = JwtUtils.parseJwt(jwt);
//        log.info("解析得到{}",claims);
//       claims.get("") ;
//    log.info("信息{}",s1);
//    }
}
