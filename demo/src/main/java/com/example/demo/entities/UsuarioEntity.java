package com.example.demo.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.enums.PerfilUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "usuario")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "endereco", nullable = false)
    private String address;

    @Column(name = "telefone", nullable = false)
    private String phone;

    @Column(name = "area_cobertura", nullable = false)
    private String areaWork;

    @Column(name = "senha", nullable = false)
    private String password;

    @Column(name = "is_active")
    private boolean isActive = true;

    // @Enumerated(EnumType.STRING)
    // private PerfilUsuario tipo;

    @OneToMany(mappedBy = "biologist")
    private List<DenunciaEntity> denunciasBiologistList;

    @OneToMany(mappedBy = "fiscal")
    private List<DenunciaEntity> denunciasFiscalList;

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

    public String getPassword() {
        return password;
    }

    public String getAreaWork() {
        return areaWork;
    }

    public void setAreaWork(String areaWork) {
        this.areaWork = areaWork;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public PerfilUsuario getTipo() {
    //     return tipo;
    // }

    // public void setTipo(PerfilUsuario tipo) {
    //     this.tipo = tipo;
    // }

    public List<DenunciaEntity> getDenunciasBiologistList() {
        return denunciasBiologistList;
    }

    public void setDenunciasBiologistList(List<DenunciaEntity> denunciasBiologistList) {
        this.denunciasBiologistList = denunciasBiologistList;
    }

    public List<DenunciaEntity> getDenunciasFiscalList() {
        return denunciasFiscalList;
    }

    public void setDenunciasFiscalList(List<DenunciaEntity> denunciasFiscalList) {
        this.denunciasFiscalList = denunciasFiscalList;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
