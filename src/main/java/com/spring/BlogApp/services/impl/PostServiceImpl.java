package com.spring.BlogApp.services.impl;

import com.spring.BlogApp.entities.Category;
import com.spring.BlogApp.entities.Post;
import com.spring.BlogApp.entities.User;
import com.spring.BlogApp.exceptions.ResourceNotFoundException;
import com.spring.BlogApp.payloads.PostDto;
import com.spring.BlogApp.repositories.CategoryRepo;
import com.spring.BlogApp.repositories.PostRepo;
import com.spring.BlogApp.repositories.UserRepo;
import com.spring.BlogApp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    public PostServiceImpl(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    @Autowired
    private ModelMapper modelMapper;
    public PostServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Autowired
    private CategoryRepo categoryRepo;
    public PostServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    @Autowired
    private UserRepo userRepo;
    public PostServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }


    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        Post post = dtoToPost(postDto);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id", categoryId));
        post.setCategory(category);
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id", userId));
        post.setUser(user);

        return postToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost() {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }


    public PostDto postToDto(Post post){
        PostDto postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }

    public Post dtoToPost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }

    public PostServiceImpl() {
        // Default constructor
    }


}
