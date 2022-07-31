package com.maxqaq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maxqaq.entity.Category;

import java.util.List;

/**
 * 分类(Category)表服务接口
 *
 * @author makejava
 * @since 2022-07-30 20:06:43
 */
public interface CategoryService extends IService<Category> {

    Category insert(Category category);

    List<Category> queryByFirstLevel();

    Category MyUpdateById(Category category);

    void deleteById(Integer id);
}

