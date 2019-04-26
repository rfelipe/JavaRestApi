package com.locadora.apiLocadora.repository;

import com.locadora.apiLocadora.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme,Long> {
    Optional<Filme> findById(Long id);
    Optional<Filme> findByTitulo(String titulo);
}
