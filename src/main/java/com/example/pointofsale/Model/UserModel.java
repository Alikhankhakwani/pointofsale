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
    private Long Id;
    private String username;
    private String password;

    private boolean status;
    private long roleid;
    private RoleModel roleModel;

    public UserModel(User user) {

        this.Id=getId();
        this.username=getUsername();
       this.password=getPassword();
        this.roleModel = new RoleModel((Role) user.getRole());

    }
    // Convert model to entity
    public User disassemble() {
        User user = new User();
        RoleModel newRoleModel = new RoleModel();
        user.setId(Id);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
    // Convert entity to model
    public UserModel assemble(User user) {
        UserModel userModel = new UserModel();
        RoleModel newRoleModel1 = new RoleModel();

        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());

        userModel.setRoleModel(roleModel.assemble((Role) user.getRole()));
        return userModel;

    }
}