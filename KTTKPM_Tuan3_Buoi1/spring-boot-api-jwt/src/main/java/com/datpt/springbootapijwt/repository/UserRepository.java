package com.datpt.springbootapijwt.repository;


import com.datpt.springbootapijwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}