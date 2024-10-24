package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BiologoEntity;

public interface BiologoRepository extends JpaRepository<BiologoEntity, Long> {
    
}
