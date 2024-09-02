package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Category;
import com.example.demo.Domain.CommonSearch;
import com.example.demo.Mapper.CategoryMapper;
import com.example.demo.Mapper.SubCategoryMapper;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SubCategoryMapper subCategoryMapper;

    public List<Category> getList(CommonSearch commonSearch) {
        return categoryMapper.selectCategoryList(commonSearch);
    }

    public int addCategory(Category category) {
        return categoryMapper.addCategory(category);
    }

    public List<Category> getSubList(CommonSearch commonSearch){
        return subCategoryMapper.selectCategoryList(commonSearch);
    }

    public int addSubCategory(Category category){
        return subCategoryMapper.addSubCategory(category);
    }

    public int delCategory(Category category) {
        return categoryMapper.delCategory(category);
    }

    public int delSubCategory(Category category) {
        return subCategoryMapper.delSubCategory(category);
    }
    
}
