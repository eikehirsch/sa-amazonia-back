package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.RoleEntity;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity getRoleByName(String name) {
        Optional<RoleEntity> optional = roleRepository.findByName(name);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }

    }
}
