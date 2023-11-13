package com.spring.BlogApp.services;

import com.spring.BlogApp.payloads.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    public void deleteCategory(Integer categoryId);

    public CategoryDto getCategory(Integer categoryId);

    public List<CategoryDto> getAllCategories();
}
