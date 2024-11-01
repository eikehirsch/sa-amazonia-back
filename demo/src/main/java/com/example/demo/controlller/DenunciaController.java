package com.example.demo.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.CreateDenunciaDTO;
import com.example.demo.dtos.req.AssociateUsuarioToDenunciaDTO;
import com.example.demo.dtos.res.ShowDenunciaDTO;
import com.example.demo.services.DenunciaService;
import com.example.demo.services.UsuarioService;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired
    DenunciaService denunciaService;

    @Autowired
    UsuarioService usuarioService;

    // GET DENUNCIA
    @GetMapping("/{id}")
    public ResponseEntity<?> getDenuncia(@PathVariable long id) {

        ShowDenunciaDTO denuncia = denunciaService.getDenunciaById(id);

        return ResponseEntity.status(200).body(denuncia);
    }

    // POST
    @PostMapping("/")
    public ResponseEntity<?> createDenuncia(@RequestBody CreateDenunciaDTO dto) {

        denunciaService.createDenuncia(dto);

        return ResponseEntity.status(201).build();

    }

    // PATCH
    @PatchMapping("/{denunciaId}")
    public ResponseEntity<?> associateUsuarioToDenuncia(@PathVariable long denunciaId, @RequestBody AssociateUsuarioToDenunciaDTO dto) {

        try {
            denunciaService.associateUsuarioToDenuncia(denunciaId, dto);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(400).build();
        }
    }

    // GET ALL DENUNCIAS
    @GetMapping("/")
    public ResponseEntity<?> getAllDenuncias() {
        
        List<ShowDenunciaDTO> denunciasList = denunciaService.getAllDenuncias();

        return ResponseEntity.status(200).body(denunciasList);
    }
    
}
