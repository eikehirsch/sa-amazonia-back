package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UsuarioEntity;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    List<UsuarioEntity> findByRole_Name(String name);
}
