package com.example.pointofsale.controller;

import com.example.pointofsale.Model.UserModel;
import com.example.pointofsale.entity.User;
import com.example.pointofsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestParam String usernameOrEmail, @RequestParam String password) {

        // Get the user from the database using the username or email
        User user = userService.findByUsername(usernameOrEmail);

        // Check if the user exists and the password is correct
        if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            // Return the token to the client
            UserModel userModel = new UserModel();
            userModel.setUsername(user.getUsername());
            userModel.setUsername("your_token_here");
            return ResponseEntity.ok(userModel);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

