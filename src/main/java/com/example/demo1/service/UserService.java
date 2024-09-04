package com.example.demo1.service;

import com.example.demo1.dto.request.UpdateUser;
import com.example.demo1.dto.request.UserCreationRequest;
import com.example.demo1.entity.User;
import com.example.demo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createRequest(UserCreationRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());


        return userRepository.save(user);
    }
    public List<User> userlist(){
        return userRepository.findAll();
    }
    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser( String userId , UpdateUser request){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());
        return userRepository.save(user);
    }
    public String deleteUser(String userId ){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(userId);
        return "User deleted";

    }
}
