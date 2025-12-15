package com.ysq.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ========= FIELD LOGIN / ROLE =========
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 20)
    private String role;   // "ADMIN", "PENGAJAR", "SANTRI", dll

    // ========= BIODATA PENGAJAR / USER UMUM =========
    @Column(length = 100)
    private String nama;

    @Column(length = 255)
    private String alamat;

    @Column(length = 50)
    private String tempatLahir;

    private String tanggalLahir; // bisa diganti LocalDate kalau mau lebih rapi

    private Integer umur;

    @Column(length = 100)
    private String mapel;        // mapel diampu / role pengajar

    @Column(length = 20)
    private String noWa;

    // ========= GETTER & SETTER =========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getNoWa() {
        return noWa;
    }

    public void setNoWa(String noWa) {
        this.noWa = noWa;
    }
}
