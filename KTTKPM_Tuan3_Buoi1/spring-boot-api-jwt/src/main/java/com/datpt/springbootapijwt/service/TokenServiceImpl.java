package com.datpt.springbootapijwt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datpt.springbootapijwt.entity.Token;
import com.datpt.springbootapijwt.repository.TokenRepository;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired()
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}

