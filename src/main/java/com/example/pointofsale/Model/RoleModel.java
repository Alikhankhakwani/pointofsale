package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class RoleModel {

    private Long id;

    private String role;

    public RoleModel(Role role) {
        this.id = getId();
        this.role = getRole();
    }
    public static Role disassemble() {
        Role role = new  Role();

        role.setId(id);
        role.setRole(String.valueOf(role));

        return role;

    }

    public RoleModel assemble(Role role) {
        RoleModel roleModel = new RoleModel();


        roleModel.setId(role.getId());
        roleModel.setRole(role.setRole());

        return roleModel;

    }
}
