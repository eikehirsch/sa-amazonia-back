package com.example.demo.dtos.res;

import java.util.List;

import com.example.demo.entities.UsuarioEntity;
import com.example.demo.entities.enums.PerfilUsuario;

public class ShowUsuarioDTO {

    private long id;

    private String name;

    private String email;

    private String cpf;

    private String address;

    private String phone;

    private String areaWork;

    private String password;

    private PerfilUsuario tipo;

    private boolean isActive;

    public ShowUsuarioDTO(UsuarioEntity usuario) {
        if (usuario != null) {
            this.setId(usuario.getId());
            this.setName(usuario.getName());
            this.setEmail(usuario.getEmail());
            this.setCpf(usuario.getCpf());
            this.setAddress(usuario.getAddress());
            this.setPhone(usuario.getPhone());
            this.setAreaWork(usuario.getAreaWork());
            this.setPassword(usuario.getPassword());
            this.setTipo(usuario.getTipo());
            this.setIsActive(usuario.getIsActive());
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAreaWork() {
        return areaWork;
    }

    public void setAreaWork(String areaWork) {
        this.areaWork = areaWork;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PerfilUsuario getTipo() {
        return tipo;
    }

    public void setTipo(PerfilUsuario tipo) {
        this.tipo = tipo;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
