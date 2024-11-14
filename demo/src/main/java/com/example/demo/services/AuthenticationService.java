package com.example.demo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.LoginUserDTO;
import com.example.demo.dtos.req.RegisterUserDTO;
import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.repositories.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            RoleService roleService,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity signup(RegisterUserDTO input) {
        UsuarioEntity user = new UsuarioEntity();
        user.setUsername(input.getFullName());
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setAddress(input.getAddress());
        user.setAreaWork(input.getAreaWork());
        user.setCpf(input.getCpf());
        user.setPhone(input.getPhone());

        RoleEntity roleEntity = roleService.getRoleByName(input.getRole());

        user.setRole(roleEntity);

        return userRepository.save(user);
    }

    public UsuarioEntity authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()));

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
