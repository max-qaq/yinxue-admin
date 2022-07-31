package com.maxqaq.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分类(Category)表实体类
 *
 * @author makejava
 * @since 2022-07-30 20:06:43
 */
@SuppressWarnings("serial")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // 用在类上  用来指定json数据中包含哪些数据 JsonInclude.Include.NON_NULL 只要json中不为空的属性
public class Category extends Model<Category> {
    
    private Integer id;
    //名称
    private String name;
    //父级分类id
    @JsonProperty("parent_id")
    private Integer parentId;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deletedAt;

    private List<Category> children;//多个孩子
    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
    }

