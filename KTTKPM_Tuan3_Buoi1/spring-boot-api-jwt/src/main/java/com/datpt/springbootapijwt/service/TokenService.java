package com.datpt.springbootapijwt.service;


import com.datpt.springbootapijwt.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}