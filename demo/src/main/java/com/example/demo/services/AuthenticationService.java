package com.example.demo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.LoginUserDTO;
import com.example.demo.dtos.req.RegisterUserDTO;
import com.example.demo.dtos.res.LoginResponse;
import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.repositories.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthenticationService(
            UserRepository userRepository,
            RoleService roleService,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtService jwtService)  {
    
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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

    public LoginResponse authenticate(LoginUserDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        LoginResponse dto = new LoginResponse();
        dto.setToken(jwtToken);
        dto.setExpiresIn(jwtService.getExpirationTime());

        return dto;
    }
}
