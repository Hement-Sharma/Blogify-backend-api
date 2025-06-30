package com.telusko.service.impl;

import com.telusko.entities.Category;
import com.telusko.exceptions.ResourceNotFoundException;
import com.telusko.paylods.CategoryDto;
import com.telusko.repositery.CategoryRepo;
import com.telusko.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CategoryRepo repo;

    @Override
     public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.mapper.map(categoryDto,Category.class);
        Category savedCategory = repo.save(category);
        return this.mapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = repo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId ",categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category savedCategory = repo.save(category);

        return mapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = repo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId ",categoryId));
        repo.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = repo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId ",categoryId));
        return mapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = repo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> mapper.map(category,CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
