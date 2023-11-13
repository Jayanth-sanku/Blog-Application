package com.spring.BlogApp.repositories;
import com.spring.BlogApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
