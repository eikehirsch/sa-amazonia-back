package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.dtos.req.CreateUsuarioDTO;
import com.example.demo.dtos.res.ShowDenunciaDTO;
import com.example.demo.dtos.res.ShowUsuarioDTO;
import com.example.demo.entities.DenunciaEntity;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.entities.enums.PerfilUsuario;
import com.example.demo.services.UsuarioService;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void deveSalvarERecuperarBiologoComSucesso() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail("biologo@gmail.com");
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress("Endereço Biólogo");
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        try {
            UsuarioEntity biologoSalvo = usuarioService.createUsuario(createUsuarioDTO);

            assertEquals(createUsuarioDTO.getName(), biologoSalvo.getName());
            assertNotNull(biologoSalvo.getId());

            ShowUsuarioDTO biologoRecuperado = usuarioService.getUsuarioById(biologoSalvo.getId());

            assertNotNull(biologoRecuperado);
            assertEquals(biologoSalvo.getId(), biologoRecuperado.getId());

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void deveSalvarERecuperarFiscalComSucesso() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail("fiscal@gmail.com");
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress("Endereço Fiscal");
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.FISCAL);

        try {
            UsuarioEntity fiscalSalvo = usuarioService.createUsuario(createUsuarioDTO);

            assertEquals(createUsuarioDTO.getName(), fiscalSalvo.getName());
            assertNotNull(fiscalSalvo.getId());

            ShowUsuarioDTO fiscalRecuperado = usuarioService.getUsuarioById(fiscalSalvo.getId());

            assertNotNull(fiscalRecuperado);
            assertEquals(fiscalSalvo.getId(), fiscalRecuperado.getId());

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void deveSalvarERecuperarUsuarioSemNome() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName(null);
        createUsuarioDTO.setEmail("biologo@gmail.com");
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress("Endereço Biólogo");
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        assertThrows(Exception.class, () -> usuarioService.createUsuario(createUsuarioDTO));
    }

    @Test
    public void deveSalvarERecuperarUsuarioSemEmail() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail(null);
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress("Endereço Biólogo");
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        assertThrows(Exception.class, () -> usuarioService.createUsuario(createUsuarioDTO));
    }

    @Test
    public void deveSalvarERecuperarUsuarioSemCpf() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail("biologo@gmail.com");
        createUsuarioDTO.setCpf(null);
        createUsuarioDTO.setAddress("Endereço Biólogo");
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        assertThrows(Exception.class, () -> usuarioService.createUsuario(createUsuarioDTO));
    }

    @Test
    public void deveSalvarERecuperarUsuarioSemEndereco() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail("biologo@gmail.com");
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress(null);
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        assertThrows(Exception.class, () -> usuarioService.createUsuario(createUsuarioDTO));
    }

    @Test
    public void deveSalvarERecuperarUsuarioSemTelefone() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail("biologo@gmail.com");
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress("Endereço Biólogo");
        createUsuarioDTO.setPhone(null);
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        assertThrows(Exception.class, () -> usuarioService.createUsuario(createUsuarioDTO));
    }

    @Test
    public void deveSalvarERecuperarUsuarioSemAreaWork() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail("biologo@gmail.com");
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress("Endereço Biólogo");
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork(null);
        createUsuarioDTO.setPassword("senha");
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        assertThrows(Exception.class, () -> usuarioService.createUsuario(createUsuarioDTO));
    }

    @Test
    public void deveSalvarERecuperarUsuarioSemSenha() {

        CreateUsuarioDTO createUsuarioDTO = new CreateUsuarioDTO();
        createUsuarioDTO.setName("Primeiro usuário");
        createUsuarioDTO.setEmail("biologo@gmail.com");
        createUsuarioDTO.setCpf("981981981");
        createUsuarioDTO.setAddress("Endereço Biólogo");
        createUsuarioDTO.setPhone("849849849");
        createUsuarioDTO.setAreaWork("SC");
        createUsuarioDTO.setPassword(null);
        createUsuarioDTO.setTipo(PerfilUsuario.BIOLOGO);

        assertThrows(Exception.class, () -> usuarioService.createUsuario(createUsuarioDTO));
    }
}
