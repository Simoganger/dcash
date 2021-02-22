package com.dreamcashgroup.dcash.user.repository;

import com.dreamcashgroup.dcash.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
    Optional<Token> findByCode(String code);
}
