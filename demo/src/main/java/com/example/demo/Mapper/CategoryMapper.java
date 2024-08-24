package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Domain.Category;
import com.example.demo.Domain.CommonSearch;

@Mapper
public interface CategoryMapper {

    List<Category> selectCategoryList(CommonSearch commonSearch);

    void addCategory(Category category);
    
}
