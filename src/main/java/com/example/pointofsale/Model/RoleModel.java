package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {
    private Long id;
    private String roleName;

    public RoleModel(Role role) {
        this.id = role.getId();
        this.roleName = role.getRoleName();
    }

    public Role toEntity() {
        Role role = new Role();
        role.setId(id);
        role.setRoleName(roleName);
        return role;
    }
}

