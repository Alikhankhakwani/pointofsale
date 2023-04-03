package com.example.pointofsale.repo;

import com.example.pointofsale.entity.Supplier;
import com.example.pointofsale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
