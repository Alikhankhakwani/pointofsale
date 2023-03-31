package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Role;
import com.example.pointofsale.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class UserModel {
    private Long id;
    private String username;
    private String password;
    private RoleModel roleModel;

    public UserModel(User user) {
        this.id= user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roleModel=new RoleModel((Role) user.getRoles());
    }

    public User disassemble() {
        User user = new User();
        RoleModel newRoleModel = new RoleModel();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(RoleModel.disassemble());
        return user;
    }
    public UserModel assemble(User user) {
        UserModel userModel = new UserModel();
        RoleModel newRoleModel1 = new RoleModel();

        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());

        userModel.setRoleModel(roleModel.assemble(user.g));
        return userModel;

    }
}