package com.maxqaq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: yinxue-admin
 * @description:
 * @author: max-qaq
 * @create: 2022-07-28 19:07
 **/

@RestController
@RequestMapping("videos")
public class DemoController {

    @GetMapping("/demos")
    public String demos(){
        return "videoDemos";
    }
}
