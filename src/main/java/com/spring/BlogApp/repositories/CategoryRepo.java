package com.spring.BlogApp.repositories;

import com.spring.BlogApp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
