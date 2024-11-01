package com.example.demo.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CreateUsuarioDTO;
import com.example.demo.dtos.res.ShowUsuarioDTO;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.entities.enums.PerfilUsuario;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void createUsuario(CreateUsuarioDTO dto) throws Exception {

        // Cria um usuario
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setName(dto.getName());
        usuarioEntity.setEmail(dto.getEmail());
        usuarioEntity.setCpf(dto.getCpf());
        usuarioEntity.setAddress(dto.getAddress());
        usuarioEntity.setPhone(dto.getPhone());
        usuarioEntity.setAreaWork(dto.getAreaWork());
        usuarioEntity.setPassword(dto.getPassword());
        usuarioEntity.setTipo(dto.getTipo());

        // Salva usuario
        try {
            usuarioEntity = usuarioRepository.save(usuarioEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }

    public ShowUsuarioDTO getUsuarioById(long id) {
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(id);

        if (optionalUsuarioEntity.isEmpty()) {
            //
        }

        UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();

        ShowUsuarioDTO showUsuarioDTO = new ShowUsuarioDTO(usuarioEntity);

        return showUsuarioDTO;
    }

    public List<ShowUsuarioDTO> getAllUsuarios() {

        List<UsuarioEntity> usuariosList = usuarioRepository.findAll();

        return usuariosList
                .stream()
                .map(usuario -> {
                    ShowUsuarioDTO showUsuarioDTO = new ShowUsuarioDTO(usuario);

                    return showUsuarioDTO;
                }).toList();
    }

    public List<ShowUsuarioDTO> getFiscalsWithoutDenuncia() {

        List<UsuarioEntity> allUsuariosList = usuarioRepository.findByTipo(PerfilUsuario.FISCAL);
       
        return allUsuariosList
                .stream()
                .filter(usuario -> usuario.getDenunciasFiscalList().size() == 0)
                .map(usuario -> {
                    ShowUsuarioDTO showUsuarioDTO = new ShowUsuarioDTO(usuario);

                    return showUsuarioDTO;

                }).toList();
    }

    public List<ShowUsuarioDTO> getBiologistWithoutDenuncia() {

        List<UsuarioEntity> allUsuariosList = usuarioRepository.findByTipo(PerfilUsuario.BIOLOGO);

        return allUsuariosList
                .stream()
                .filter(usuario -> usuario.getDenunciasBiologistList().size() == 0)
                .map(usuario -> {

                    ShowUsuarioDTO showUsuarioDTO = new ShowUsuarioDTO(usuario);

                    return showUsuarioDTO;

                }).toList();
    }
}
