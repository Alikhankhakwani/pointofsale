package com.example.pointofsale.repo;

import com.example.pointofsale.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
//    public Role getRoleByEmail(String email);
}
