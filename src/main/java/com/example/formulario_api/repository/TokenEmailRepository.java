package com.example.formulario_api.repository;

import com.example.formulario_api.domain.model.TokenEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenEmailRepository extends JpaRepository<TokenEmail, Long> {
    TokenEmail findByEmail(String email);
}
