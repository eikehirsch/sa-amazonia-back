package com.example.demo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.CreateUsuarioDTO;
import com.example.demo.dtos.res.ShowUsuarioDTO;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.entities.enums.TipoDenuncia;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // GET DENUNCIA
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable long id) {

        ShowUsuarioDTO usuario = usuarioService.getUsuarioById(id);

        return ResponseEntity.status(200).body(usuario);
    }

    // POST
    @PostMapping("/")
    public ResponseEntity<?> createUsuario(@RequestBody CreateUsuarioDTO dto) {

        try {
            usuarioService.createUsuario(dto);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }

    }

}
