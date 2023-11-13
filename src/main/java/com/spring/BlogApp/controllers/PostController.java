package com.spring.BlogApp.controllers;


import com.spring.BlogApp.payloads.PostDto;
import com.spring.BlogApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createUser(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDto createPostDto = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPostDto, HttpStatus.CREATED);
    }
}
