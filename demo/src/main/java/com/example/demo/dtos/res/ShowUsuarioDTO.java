package com.example.demo.dtos.res;

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

    
}
