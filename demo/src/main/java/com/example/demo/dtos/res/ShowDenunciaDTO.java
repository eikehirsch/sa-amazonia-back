package com.example.demo.dtos.res;

import java.time.LocalDate;

import com.example.demo.entities.UsuarioEntity;
import com.example.demo.entities.enums.StatusDenuncia;
import com.example.demo.entities.enums.TipoDenuncia;

public class ShowDenunciaDTO {

    private long id;

    private String title;

    private TipoDenuncia type;

    private String location;

    private String uf;

    private String description;

    private LocalDate date;

    private ShowUsuarioDTO biologist;

    private ShowUsuarioDTO fiscal;

    private StatusDenuncia status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TipoDenuncia getType() {
        return type;
    }

    public void setType(TipoDenuncia type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ShowUsuarioDTO getBiologist() {
        return biologist;
    }

    public void setBiologist(ShowUsuarioDTO biologist) {
        this.biologist = biologist;
    }

    public ShowUsuarioDTO getFiscal() {
        return fiscal;
    }

    public void setFiscal(ShowUsuarioDTO fiscal) {
        this.fiscal = fiscal;
    }

    public StatusDenuncia getStatus() {
        return status;
    }

    public void setStatus(StatusDenuncia status) {
        this.status = status;
    }

}
