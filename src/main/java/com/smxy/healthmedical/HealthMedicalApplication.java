package com.smxy.healthmedical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.smxy.healthmedical.dao")
@EnableCaching  //开启基于注解的缓存
public class HealthMedicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthMedicalApplication.class, args);
    }

}
