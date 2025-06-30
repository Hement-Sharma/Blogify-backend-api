package com.telusko.controllers;

import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.telusko.paylods.ApiResponse;
import com.telusko.paylods.CategoryDto;
import com.telusko.service.CategoryService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
public class CategoryController {

    @Autowired
    CategoryService service;

    @PostMapping("category")
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto){
       CategoryDto savedCategory = service.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("category/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto updatedCategory = service.updateCategory(categoryDto,catId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("category/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        service.deleteCategory(catId);
        return new ResponseEntity<>(new ApiResponse("Category Deleted SuccessFylly ",true),HttpStatus.OK);
    }

    @GetMapping("category/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = service.getCategory(catId);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }

    @GetMapping("categorys")
    public ResponseEntity<List<CategoryDto>> getCategory(){
        List<CategoryDto> categoryDtos = service.getCategories();
        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }

}
