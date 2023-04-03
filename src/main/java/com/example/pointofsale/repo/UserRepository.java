package com.example.pointofsale.repo;

import com.example.pointofsale.entity.Supplier;
import com.example.pointofsale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByUsername(String incomingUsername);

    public User findByUsernameAndPassword (String incomingUsername, String incomingPassword);

}
