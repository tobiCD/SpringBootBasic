package com.example.demo1.controller;

import com.example.demo1.dto.request.ApiResponse;
import com.example.demo1.dto.request.UpdateUser;
import com.example.demo1.dto.request.UserCreationRequest;
import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(request));
        return apiResponse;
    }
    @GetMapping
    List<User> getUsers() {
        return userService.userlist();
    }
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);

    }
    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UpdateUser request) {
        return userService.updateUser(userId,request );
    }
    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable  String userId) {
        userService.deleteUser(userId);
    }
}
