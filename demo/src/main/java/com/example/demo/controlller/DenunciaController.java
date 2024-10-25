package com.example.demo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.CreateDenunciaDTO;
import com.example.demo.services.DenunciaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/denuncias")
public class DenunciaController {
    
    @Autowired
    DenunciaService denunciaService;

    //POST
    @PostMapping()
    public ResponseEntity<?> createDenuncia(@RequestBody CreateDenunciaDTO dto) {
        
        denunciaService.createDenuncia(dto);
        
        return ResponseEntity.status(201).build();
    }
    
}
