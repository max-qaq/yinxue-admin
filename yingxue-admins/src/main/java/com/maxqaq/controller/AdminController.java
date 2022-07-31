package com.maxqaq.controller;

import com.maxqaq.constants.RedisPrefix;
import com.maxqaq.dto.AdminDTO;
import com.maxqaq.entity.Admin;
import com.maxqaq.service.AdminService;
import com.maxqaq.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2022-07-29 15:10:23
 */
@RestController
@Slf4j
public class AdminController {

    private AdminService adminService;

    private RedisTemplate redisTemplate;

    @Autowired
    public AdminController(AdminService adminService, RedisTemplate redisTemplate) {
        this.adminService = adminService;
        this.redisTemplate = redisTemplate;
    }


    //登录
    @PostMapping("/tokens")
    public Map<String,String> tokens(@RequestBody Admin admin ,HttpSession session){
        Map<String, String> result = new HashMap<>();
        log.info("admin/tokens 接收到的参数--->{}", JsonUtils.getJson(admin));
        Admin adminDB = adminService.login(admin);
        //3.登录成功
        String token = session.getId();
        redisTemplate.opsForValue().set(RedisPrefix.TOKEN_KEY + token, adminDB, 30, TimeUnit.MINUTES);
        result.put("token", token);
        return result;
    }

    //已登录用户信息  //vo value object view object   //dto data transfer object  推荐
    @GetMapping("/admin-user")
    public AdminDTO admin(@RequestParam String token) {
        log.info("当前token信息: {}", token);
        Admin admin = (Admin) redisTemplate.opsForValue().get(RedisPrefix.TOKEN_KEY + token);
        AdminDTO adminDTO = new AdminDTO();
        //1.属性复制
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }

    //登出接口
    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable("token") String token) {
        redisTemplate.delete(RedisPrefix.TOKEN_KEY + token);
    }
}

