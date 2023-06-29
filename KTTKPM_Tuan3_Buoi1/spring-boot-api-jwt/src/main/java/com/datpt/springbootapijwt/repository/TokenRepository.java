package com.datpt.springbootapijwt.repository;


import com.datpt.springbootapijwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
