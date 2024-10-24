package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FiscalEntity;

public interface FiscalRepository extends JpaRepository<FiscalEntity, Long> {
    
}
 