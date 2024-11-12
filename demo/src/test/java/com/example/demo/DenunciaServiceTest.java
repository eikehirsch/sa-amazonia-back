package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.dtos.req.CreateDenunciaDTO;
import com.example.demo.dtos.res.ShowDenunciaDTO;
import com.example.demo.entities.DenunciaEntity;
import com.example.demo.entities.enums.StatusDenuncia;
import com.example.demo.entities.enums.TipoDenuncia;
import com.example.demo.services.DenunciaService;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class DenunciaServiceTest {
    
    @Autowired
    private DenunciaService denunciaService;

    @Test
    public void deveSalvarERecuperarDenunciaComSucesso() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle("Primeira denúncia");
        createDenunciaDTO.setType(TipoDenuncia.QUEIMADAS);
        createDenunciaDTO.setLocation("Perto da praça, no centro");
        createDenunciaDTO.setUf("SC");
        createDenunciaDTO.setDescription("Foi uma queimada gigantesca em um monte de árvores");
        createDenunciaDTO.setDate(LocalDate.now());
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        try {
            DenunciaEntity denunciaSalva = denunciaService.createDenuncia(createDenunciaDTO);

            assertEquals(createDenunciaDTO.getTitle(), denunciaSalva.getTitle());
            assertNotNull(denunciaSalva.getId());

            ShowDenunciaDTO denunciaRecuperada = denunciaService.getDenunciaById(denunciaSalva.getId());

            assertNotNull(denunciaRecuperada);
            assertEquals(denunciaSalva, denunciaRecuperada);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void testaCadastroDenunciaInvalidaSemTitulo() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle(null);
        createDenunciaDTO.setType(TipoDenuncia.QUEIMADAS);
        createDenunciaDTO.setLocation("Perto da praça, no centro");
        createDenunciaDTO.setUf("SC");
        createDenunciaDTO.setDescription("Foi uma queimada gigantesca em um monte de árvores");
        createDenunciaDTO.setDate(LocalDate.now());
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        assertThrows(Exception.class, () -> denunciaService.createDenuncia(createDenunciaDTO));
    }
    
    @Test
    public void testaCadastroDenunciaInvalidaSemTipo() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle("Primeira denúncia");
        createDenunciaDTO.setType(null);
        createDenunciaDTO.setLocation("Perto da praça, no centro");
        createDenunciaDTO.setUf("SC");
        createDenunciaDTO.setDescription("Foi uma queimada gigantesca em um monte de árvores");
        createDenunciaDTO.setDate(LocalDate.now());
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        assertThrows(Exception.class, () -> denunciaService.createDenuncia(createDenunciaDTO));
    }

    @Test
    public void testaCadastroDenunciaInvalidaSemLocalidade() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle("Primeira denúncia");
        createDenunciaDTO.setType(TipoDenuncia.QUEIMADAS);
        createDenunciaDTO.setLocation(null);
        createDenunciaDTO.setUf("SC");
        createDenunciaDTO.setDescription("Foi uma queimada gigantesca em um monte de árvores");
        createDenunciaDTO.setDate(LocalDate.now());
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        assertThrows(Exception.class, () -> denunciaService.createDenuncia(createDenunciaDTO));
    }

    @Test
    public void testaCadastroDenunciaInvalidaSemUf() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle("Primeira denúncia");
        createDenunciaDTO.setType(TipoDenuncia.QUEIMADAS);
        createDenunciaDTO.setLocation("Perto da praça, no centro");
        createDenunciaDTO.setUf(null);
        createDenunciaDTO.setDescription("Foi uma queimada gigantesca em um monte de árvores");
        createDenunciaDTO.setDate(LocalDate.now());
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        assertThrows(Exception.class, () -> denunciaService.createDenuncia(createDenunciaDTO));
    }

    @Test
    public void testaCadastroDenunciaInvalidaSemDescription() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle("Primeira denúncia");
        createDenunciaDTO.setType(TipoDenuncia.QUEIMADAS);
        createDenunciaDTO.setLocation("Perto da praça, no centro");
        createDenunciaDTO.setUf("SC");
        createDenunciaDTO.setDescription(null);
        createDenunciaDTO.setDate(LocalDate.now());
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        assertThrows(Exception.class, () -> denunciaService.createDenuncia(createDenunciaDTO));
    }

    @Test
    public void testaCadastroDenunciaInvalidaSemData() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle("Primeira denúncia");
        createDenunciaDTO.setType(TipoDenuncia.QUEIMADAS);
        createDenunciaDTO.setLocation("Perto da praça, no centro");
        createDenunciaDTO.setUf("SC");
        createDenunciaDTO.setDescription("Foi uma queimada gigantesca em um monte de árvores");
        createDenunciaDTO.setDate(null);
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        assertThrows(Exception.class, () -> denunciaService.createDenuncia(createDenunciaDTO));
    }

    @Test
    public void testaLerDenunciaInvalida() {

        CreateDenunciaDTO createDenunciaDTO = new CreateDenunciaDTO();
        createDenunciaDTO.setTitle("Primeira denúncia");
        createDenunciaDTO.setType(TipoDenuncia.QUEIMADAS);
        createDenunciaDTO.setLocation("Perto da praça, no centro");
        createDenunciaDTO.setUf("SC");
        createDenunciaDTO.setDescription("Foi uma queimada gigantesca em um monte de árvores");
        createDenunciaDTO.setDate(LocalDate.now());
        createDenunciaDTO.setBiologistId(null);
        createDenunciaDTO.setFiscalId(null);

        try {
            DenunciaEntity denunciaSalva = denunciaService.createDenuncia(createDenunciaDTO);

        } catch (Exception e) {
            // TODO: handle exception
        }

        assertThrows(Exception.class, () -> denunciaService.getDenunciaById(99999l));

    }
}
