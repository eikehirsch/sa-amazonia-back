package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.DenunciaEntity;

public interface DenunciaRepository extends JpaRepository<DenunciaEntity, Long> {
    
}
