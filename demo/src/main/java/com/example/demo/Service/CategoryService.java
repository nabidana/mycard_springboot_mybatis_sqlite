package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Category;
import com.example.demo.Domain.CommonSearch;
import com.example.demo.Mapper.CategoryMapper;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getList(CommonSearch commonSearch) {
        return categoryMapper.selectCategoryList(commonSearch);
    }

    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }
    
}
