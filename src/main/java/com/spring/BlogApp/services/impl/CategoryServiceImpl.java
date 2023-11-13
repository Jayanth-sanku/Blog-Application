package com.spring.BlogApp.services.impl;

import com.spring.BlogApp.entities.Category;
import com.spring.BlogApp.entities.User;
import com.spring.BlogApp.exceptions.ResourceNotFoundException;
import com.spring.BlogApp.payloads.CategoryDto;
import com.spring.BlogApp.payloads.UserDto;
import com.spring.BlogApp.repositories.CategoryRepo;
import com.spring.BlogApp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo;
    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }


    @Autowired
    private ModelMapper modelMapper;




    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category newCategory = dtoToCategory(categoryDto);
        categoryRepo.save(newCategory);
        return categoryToDto(newCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id", categoryId));
        category = this.dtoToCategory(categoryDto);
        Category updatedCategory = categoryRepo.save(category);
        return this.categoryToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id", categoryId));
        categoryRepo.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id", categoryId));
//        category = dtoToCategory(categoryDto);
//        Category updatedCategory = categoryRepo.save(category);
        return this.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();

        List<CategoryDto> categoryDtos = categories.stream()
                .map(this::categoryToDto) // Assuming userToDto is a method in your class
                .collect(Collectors.toList());
        return categoryDtos;
    }


    private Category dtoToCategory(CategoryDto categoryDto){
        Category newCategory = this.modelMapper.map(categoryDto, Category.class);
        return  newCategory;
    }

    private CategoryDto categoryToDto(Category category){
        CategoryDto newcategoryDto = this.modelMapper.map(category, CategoryDto.class);
        return  newcategoryDto;
    }

}
