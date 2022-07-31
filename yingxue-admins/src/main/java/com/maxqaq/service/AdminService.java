package com.maxqaq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maxqaq.entity.Admin;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2022-07-29 15:27:49
 */
public interface AdminService extends IService<Admin> {

    //登录方法
    Admin login(Admin admin);
}

