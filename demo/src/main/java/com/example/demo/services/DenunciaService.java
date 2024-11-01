package com.example.demo.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.AssociateUsuarioToDenunciaDTO;
import com.example.demo.dtos.req.CreateDenunciaDTO;
import com.example.demo.dtos.res.ShowDenunciaDTO;
import com.example.demo.dtos.res.ShowUsuarioDTO;
import com.example.demo.entities.DenunciaEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.entities.enums.TipoDenuncia;
import com.example.demo.repositories.DenunciaRepository;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public void createDenuncia(CreateDenunciaDTO dto) {

        // Cria uma denuncia
        DenunciaEntity denunciaEntity = new DenunciaEntity();
        denunciaEntity.setTitle(dto.getTitle());
        denunciaEntity.setType(dto.getType().toString());
        denunciaEntity.setLocation(dto.getLocation());
        denunciaEntity.setDate(dto.getDate());
        denunciaEntity.setDescription(dto.getDescription());
        denunciaEntity.setUf(dto.getUf());

        // Salva denuncia
        try {
            denunciaEntity = denunciaRepository.save(denunciaEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void alterarDenuncia(ShowDenunciaDTO dto, ShowUsuarioDTO biologo, ShowUsuarioDTO fiscal) {

    }

    public ShowDenunciaDTO getDenunciaById(long id) {

        Optional<DenunciaEntity> optionalDenunciaEntity = denunciaRepository.findById(id);

        if (optionalDenunciaEntity.isEmpty()) {
            //
        }

        DenunciaEntity denunciaEntity = optionalDenunciaEntity.get();

        ShowDenunciaDTO showDenunciaDTO = new ShowDenunciaDTO();
        showDenunciaDTO.setId(denunciaEntity.getId());
        showDenunciaDTO.setTitle(denunciaEntity.getTitle());
        showDenunciaDTO.setType(TipoDenuncia.valueOf(denunciaEntity.getType()));
        showDenunciaDTO.setLocation(denunciaEntity.getLocation());
        showDenunciaDTO.setUf(denunciaEntity.getUf());
        showDenunciaDTO.setDescription(denunciaEntity.getDescription());
        showDenunciaDTO.setDate(denunciaEntity.getDate());
        if (denunciaEntity.getBiologist() != null)
            showDenunciaDTO.setBiologist(new ShowUsuarioDTO(denunciaEntity.getBiologist()));
        if (denunciaEntity.getFiscal() != null)
            showDenunciaDTO.setFiscal(new ShowUsuarioDTO(denunciaEntity.getFiscal()));

        return showDenunciaDTO;
    }

    public void associateUsuarioToDenuncia(long denunciaId, AssociateUsuarioToDenunciaDTO dto) {

        // Pega o biologo
        ShowUsuarioDTO biologo = usuarioService.getUsuarioById(dto.getIdBiologist());

        // Pega o fiscal
        ShowUsuarioDTO fiscal = usuarioService.getUsuarioById(dto.getIdFiscal());

        // Pega a denuncia
        Optional<DenunciaEntity> optionalDenunciaEntity = denunciaRepository.findById(denunciaId);

        if (optionalDenunciaEntity.isEmpty()) {
            //
        }

        DenunciaEntity denunciaEntity = optionalDenunciaEntity.get();

        UsuarioEntity biologoEntity = new UsuarioEntity();
        biologoEntity.setId(biologo.getId());
        denunciaEntity.setBiologist(biologoEntity);

        UsuarioEntity fiscalEntity = new UsuarioEntity();
        fiscalEntity.setId(fiscal.getId());
        denunciaEntity.setFiscal(fiscalEntity);

        denunciaRepository.save(denunciaEntity);
    }

    public List<ShowDenunciaDTO> getAllDenuncias() {

        List<DenunciaEntity> denunciasList = denunciaRepository.findAll();

        return denunciasList
                .stream()
                .map(denuncia -> {

                    ShowDenunciaDTO showDenunciaDTO = new ShowDenunciaDTO();
                    showDenunciaDTO.setId(denuncia.getId());
                    showDenunciaDTO.setTitle(denuncia.getTitle());
                    showDenunciaDTO.setType(TipoDenuncia.valueOf(denuncia.getType()));
                    showDenunciaDTO.setLocation(denuncia.getLocation());
                    showDenunciaDTO.setUf(denuncia.getUf());
                    showDenunciaDTO.setDescription(denuncia.getDescription());
                    showDenunciaDTO.setDate(denuncia.getDate());
                    if (denuncia.getBiologist() != null)
                        showDenunciaDTO.setBiologist(new ShowUsuarioDTO(denuncia.getBiologist()));
                    if (denuncia.getFiscal() != null)
                        showDenunciaDTO.setFiscal(new ShowUsuarioDTO(denuncia.getFiscal()));

                    return showDenunciaDTO;

                }).toList();
    }
}
