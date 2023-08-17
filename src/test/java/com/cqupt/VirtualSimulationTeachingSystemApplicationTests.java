package com.cqupt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.Entity.SimulationEquipment;
import com.cqupt.mapper.SimulationEquipmentMapper;
import com.cqupt.utils.SMSUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class VirtualSimulationTeachingSystemApplicationTests {
      @Autowired
      private SimulationEquipmentMapper simulationEquipmentMapper;

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
    @Test
    public void testPage(){
        //坑，大坑，用的springboot3.0以上版本，mybatisplus需要用3.5.3.1版本
        // 服了啊，前前后后搞了半天左右
        Page<SimulationEquipment> page = new Page<SimulationEquipment>(1,3);
       simulationEquipmentMapper.selectPage(page, null);
        System.out.println(page.getRecords());
//        SimulationEquipment simulationEquipment = simulationEquipmentMapper.selectById(1);
//        System.out.println(simulationEquipment);
    }

    @Test
    public void Test(){
        String param = "1234324";
        System.out.println("{\"code\":\""+param+"\"}");
//        System.out.println("{\"code\":\"1234\"}");
        SMSUtils.sendMessage("cquptfan","SMS_462570807","13072349855","132123");
    }
}
