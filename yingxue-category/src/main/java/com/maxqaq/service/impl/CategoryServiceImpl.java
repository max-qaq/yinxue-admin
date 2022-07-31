package com.maxqaq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maxqaq.dao.CategoryDao;
import com.maxqaq.entity.Category;
import com.maxqaq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 分类(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-07-30 20:06:43
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category insert(Category category) {
        Date date = new Date();
        category.setCreatedAt(date);
        category.setUpdatedAt(date);
        this.categoryDao.insert(category);
        return category;//存在id
    }

    @Override
    public List<Category> queryByFirstLevel() {
        return categoryDao.queryByFirstLevel();
    }

    @Override
    public Category MyUpdateById(Category category) {
        categoryDao.update(category);
        return categoryDao.queryById(category.getId());
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }
}

