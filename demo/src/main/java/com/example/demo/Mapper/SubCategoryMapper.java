package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.example.demo.Domain.Category;
import com.example.demo.Domain.CommonSearch;

@Mapper
public interface SubCategoryMapper {
    
    List<Category> selectCategoryList(CommonSearch commonSearch);

    int addSubCategory(Category category);

    int delSubCategory(Category category);

}
