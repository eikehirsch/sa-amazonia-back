package com.example.demo.dtos.req;

import java.time.LocalDate;

public class CreateDenunciaDTO {
    
    private String title;

    private String type;

    private String location;

    private String uf;

    private String description; 

    private LocalDate date;

    private CreateBiologoDTO biologist;

    private CreateFiscalDTO fiscal;

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

    public CreateBiologoDTO getBiologist() {
        return biologist;
    }

    public void setBiologist(CreateBiologoDTO biologist) {
        this.biologist = biologist;
    }

    public CreateFiscalDTO getFiscal() {
        return fiscal;
    }

    public void setFiscal(CreateFiscalDTO fiscal) {
        this.fiscal = fiscal;
    }
    
    
}
