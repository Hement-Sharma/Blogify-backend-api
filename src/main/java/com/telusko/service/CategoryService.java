package com.telusko.service;

import com.telusko.entities.Category;
import com.telusko.paylods.CategoryDto;
import org.hibernate.IdentifierLoadAccess;

import java.util.List;

public interface CategoryService {
     CategoryDto createCategory(CategoryDto categoryDto);
     CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
     void deleteCategory(Integer categoryId);
     CategoryDto getCategory(Integer categoryId);
     List<CategoryDto> getCategories();
}
