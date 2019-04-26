package com.locadora.apiLocadora.repository;

import com.locadora.apiLocadora.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository <Usuario, String> {
        Optional<Usuario> findByEmail(String email);
        Optional<Usuario> findBySenha(String senha);
}
