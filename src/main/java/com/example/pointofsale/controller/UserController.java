package com.example.pointofsale.controller;

import com.example.pointofsale.Model.UserModel;
import com.example.pointofsale.entity.User;
import com.example.pointofsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel userModel) {

        // Get the user from the database using the username
        User user = userService.findByUsername(userModel.getUsername());


        // Return the token to the client
        return ResponseEntity.ok(userModel);
    }
}

