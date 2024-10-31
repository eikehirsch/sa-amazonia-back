package com.example.demo.dtos.req;

public class AssociateUsuarioToDenunciaDTO {
    
    private long idBiologist;

    private long idFiscal;

    public long getIdBiologist() {
        return idBiologist;
    }

    public void setIdBiologist(long idBiologist) {
        this.idBiologist = idBiologist;
    }

    public long getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(long idFiscal) {
        this.idFiscal = idFiscal;
    }
}
