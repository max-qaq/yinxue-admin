package com.maxqaq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: yinxue-admin
 * @description:
 * @author: max-qaq
 * @create: 2022-07-28 10:33
 **/
@SpringBootApplication
@MapperScan("com.maxqaq.dao")
public class AdminAdminsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminAdminsApplication.class,args);
    }
}
