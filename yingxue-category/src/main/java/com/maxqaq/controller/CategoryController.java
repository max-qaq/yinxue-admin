package com.maxqaq.controller;

import com.maxqaq.entity.Category;
import com.maxqaq.service.CategoryService;
import com.maxqaq.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 分类(Category)表控制层
 *
 * @author makejava
 * @since 2022-07-30 20:06:43
 */
@RestController
@RequestMapping("categories")
@Slf4j
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    //删除类别
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        log.info("删除类别id: {}", id);
        categoryService.deleteById(id);
    }

    //添加类别接口
    @PostMapping  //{name:"xxx","parent_id":1}
    public Category save(@RequestBody Category category) {
        log.info("添加类别信息: {}", JsonUtils.getJson(category));
        category = categoryService.insert(category);
        log.info("添加之后类别信息: {}", JsonUtils.getJson(category));
        return category;
    }

    //修改列表接口
    @PatchMapping("/{id}")  //{"name":"","parent_id":..}
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
        log.info("更新类别id: {}", id);
        log.info("更新类别信息: {}", JsonUtils.getJson(category));
        //1.更新
        category.setId(id);
        return categoryService.MyUpdateById(category);
    }

    //类别列表
    @GetMapping
    public List<Category> categories() {
        return categoryService.queryByFirstLevel();
    }

}

