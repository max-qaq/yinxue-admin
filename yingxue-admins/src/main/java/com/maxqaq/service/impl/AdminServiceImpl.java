package com.maxqaq.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maxqaq.dao.AdminDao;
import com.maxqaq.entity.Admin;
import com.maxqaq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2022-07-29 15:27:54
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

    private AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin login(Admin admin) {
        //1.根据用户名查询用户
        Admin adminDB = adminDao.selectOne(new LambdaQueryWrapper<Admin>()
                .eq(Admin::getUsername, admin.getUsername()));
        //2.判断用户是否存在
        if (ObjectUtils.isEmpty(adminDB)) throw new RuntimeException("用户名错误!");
        //3.判断密码
        String password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes(StandardCharsets.UTF_8));
        if (!StringUtils.equals(password, adminDB.getPassword())) throw new RuntimeException("密码输入错误!");
        return adminDB;
    }
}

