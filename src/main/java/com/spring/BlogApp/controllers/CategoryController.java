package com.spring.BlogApp.controllers;


import com.spring.BlogApp.payloads.ApiResponse;
import com.spring.BlogApp.payloads.CategoryDto;
import com.spring.BlogApp.payloads.UserDto;
import com.spring.BlogApp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/categories")
@RestController
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategoryDto = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        CategoryDto updatedCategoryDto = categoryService.updateCategory(categoryDto, id);
        return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id){
        CategoryDto updatedCategoryDto = categoryService.getCategory(id);
        return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categoriesList = categoryService.getAllCategories();
        return categoriesList;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully!!!", true), HttpStatus.OK);
    }

}
