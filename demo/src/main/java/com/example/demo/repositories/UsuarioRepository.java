package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UsuarioEntity;
import java.util.List;
import com.example.demo.entities.enums.PerfilUsuario;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    public List<UsuarioEntity> findByTipo(PerfilUsuario tipo);
}
