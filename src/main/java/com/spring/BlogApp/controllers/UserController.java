package com.spring.BlogApp.controllers;

import com.spring.BlogApp.payloads.ApiResponse;
import com.spring.BlogApp.payloads.UserDto;
import com.spring.BlogApp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer id){
        UserDto updatedUserDto = userService.updateUser(userDto, id);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public List<UserDto> getAllUsers(){
        List<UserDto> list = userService.getAllUsers();
        return list;
    }

    @GetMapping("{id}/")
    public UserDto getUserById(@PathVariable Integer id){
        UserDto getUser = userService.getUserById(id);
        return getUser;
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully!!!", true), HttpStatus.OK);
    }

}
