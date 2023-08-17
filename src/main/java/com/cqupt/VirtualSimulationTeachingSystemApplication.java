package com.cqupt;

import lombok.SneakyThrows;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqupt.mapper")
public class VirtualSimulationTeachingSystemApplication {

    @SneakyThrows
    public static void main(String[] args) throws Exception  {
        SpringApplication.run(VirtualSimulationTeachingSystemApplication.class, args);
    }


}
