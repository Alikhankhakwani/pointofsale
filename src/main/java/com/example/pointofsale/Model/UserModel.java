package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Role;
import com.example.pointofsale.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String username;
    private List<RoleModel> roles;

    public UserModel(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles().stream()
                .map(RoleModel::new)
                .collect(Collectors.toList());
    }

    public User toEntity() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setRoles(roles.stream()
                .map(RoleModel::toEntity)
                .collect(Collectors.toList()));
        return user;
    }
}
