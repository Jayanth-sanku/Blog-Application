package com.spring.BlogApp.repositories;

import com.spring.BlogApp.entities.Category;
import com.spring.BlogApp.entities.Post;
import com.spring.BlogApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
