package com.maxqaq.controller;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: yinxue-admin
 * @description:
 * @author: max-qaq
 * @create: 2022-07-28 19:05
 **/
@RestController
@RequestMapping("demos")
public class DemoController {

    @GetMapping("")
    public String demos(){
        return "adminDemos";
    }
}
