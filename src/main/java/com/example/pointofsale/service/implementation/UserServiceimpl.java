//package com.example.pointofsale.service.implementation;
//
//import com.example.pointofsale.Model.UserLoginModel;
//import com.example.pointofsale.Model.UserModel;
//import com.example.pointofsale.entity.Role;
//import com.example.pointofsale.entity.User;
//import com.example.pointofsale.repo.RoleRepository;
//import com.example.pointofsale.repo.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class UserServiceimpl implements UserService1 {
//
//    @Autowired
//    public UserRepository userRepository;
//    @Autowired
//    public RoleRepository roleRepository;
//
//
//
//
//    public String saveuser(UserModel userModel) {
//
//        String incomingUsername = userModel.getUsername();
//        User userExist = userRepository.findUserByUsername(incomingUsername);
//        if (userExist != null) {
//            return "User already exist with same Username";
//        } else {
//
//            Role role = new Role();
//            role.setId(userModel.getRoleid());
//            User user=userRepository.save(userModel.disassemble());
//
//
//            userRepository.save(user);
//            return "User saved successfully!";
//        }
//    }
//
//    public String isUserExist(UserLoginModel userLoginModel){
//        String incomingEmail= userLoginModel.getUsername();
//        String incomingPassword=userLoginModel.getPassword();
//        User confirmDetail= userRepository.findByUsernameAndPassword(incomingEmail,incomingPassword);
//        if (confirmDetail!=null)
//        {
//            return "Login successfully" ;
//
//        }else {
//            return "User not Exist Please Signup...";
//
//        }
//    }
//}


