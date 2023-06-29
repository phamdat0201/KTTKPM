package com.datpt.springbootapijwt.service;


import com.datpt.springbootapijwt.authen.UserPrincipal;
import com.datpt.springbootapijwt.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
