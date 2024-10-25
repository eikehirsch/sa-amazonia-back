package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "denuncia")
public class DenunciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titulo")
    private String title;

    @Column(name = "tipo")
    private String type;

    @Column(name = "localidade")
    private String location;

    @Column(name = "uf")
    private String uf;

    @Column(name = "descricao")
    private String description;

    @Column(name = "data")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "biologo_id")
    private UsuarioEntity biologist;

    @ManyToOne
    @JoinColumn(name = "fiscal_id")
    private UsuarioEntity fiscal;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public UsuarioEntity getBiologist() {
        return biologist;
    }

    public void setBiologist(UsuarioEntity biologist) {
        this.biologist = biologist;
    }

    public UsuarioEntity getFiscal() {
        return fiscal;
    }

    public void setFiscal(UsuarioEntity fiscal) {
        this.fiscal = fiscal;
    }
}
