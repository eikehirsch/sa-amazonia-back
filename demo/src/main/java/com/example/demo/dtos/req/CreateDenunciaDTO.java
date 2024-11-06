package com.example.demo.dtos.req;

import java.time.LocalDate;

import com.example.demo.entities.enums.TipoDenuncia;

public class CreateDenunciaDTO {
    
    private String title;

    private TipoDenuncia type;

    private String location;

    private String uf;

    private String description; 

    private LocalDate date;

    private Long biologistId;

    private Long fiscalId;

    private boolean isActive;

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

    public Long getBiologistId() {
        return biologistId;
    }

    public void setBiologistId(Long biologistId) {
        this.biologistId = biologistId;
    }

    public Long getFiscalId() {
        return fiscalId;
    }

    public void setFiscalId(Long fiscalId) {
        this.fiscalId = fiscalId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }  
}
