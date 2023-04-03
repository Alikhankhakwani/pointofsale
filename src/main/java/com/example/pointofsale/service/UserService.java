package com.example.pointofsale.service;

import com.example.pointofsale.Model.UserLoginModel;
import com.example.pointofsale.entity.User;
import com.example.pointofsale.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

@Autowired
UserRepository userRepository;



    public java.lang.String isUserExist(UserLoginModel userLoginModel){
        java.lang.String incomingUsername= userLoginModel.getUsername();
        java.lang.String incomingPassword=userLoginModel.getPassword();
        User confirmDetail= userRepository.findByUsernameAndPassword(incomingUsername,incomingPassword);
        if (confirmDetail!=null)
        {
            return "Login successfully" ;

        }else {
            return "User Doesn't Exist Please ";

        }
    }
}
