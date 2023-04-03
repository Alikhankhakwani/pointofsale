package com.example.pointofsale.controller;


import com.example.pointofsale.Model.UserLoginModel;
import com.example.pointofsale.Model.UserModel;
import com.example.pointofsale.service.implementation.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    public UserService1 userService1;

    @PostMapping(path = "signup")
    public String signup(@RequestBody UserModel userModel)
    {
      return userService1.saveuser(userModel);
    }
    @GetMapping(path = "login")
    public String login(@RequestBody UserLoginModel userLoginModel)
    {

        return userService1.isUserExist(userLoginModel);
    }
}
