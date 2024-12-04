package com.example.demo.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.LoginUserDTO;
import com.example.demo.dtos.req.RegisterUserDTO;
import com.example.demo.dtos.res.LoginResponse;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UsuarioEntity> register(@RequestBody RegisterUserDTO registerUserDto) {
        UsuarioEntity registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        LoginResponse authenticatedUser = authenticationService.authenticate(loginUserDto);

        return ResponseEntity.ok(authenticatedUser);
    }
}
