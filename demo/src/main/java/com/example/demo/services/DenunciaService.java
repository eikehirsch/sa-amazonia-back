package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CreateDenunciaDTO;
import com.example.demo.entities.DenunciaEntity;
import com.example.demo.repositories.DenunciaRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void createDenuncia(CreateDenunciaDTO dto) {

        // Cria uma denuncia
        DenunciaEntity denunciaEntity = new DenunciaEntity();
        denunciaEntity.setTitle(dto.getTitle());
        denunciaEntity.setType(dto.getType().toString());
        denunciaEntity.setLocation(dto.getLocation());
        denunciaEntity.setDate(dto.getDate());
        denunciaEntity.setDescription(dto.getDescription());
        denunciaEntity.setUf(dto.getUf());

        // Cria um fiscal
        // UsuarioEntity usuarioEntity = new UsuarioEntity();

        // Cria um biologo

        // Salva denuncia
        try {
            denunciaEntity = denunciaRepository.save(denunciaEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
