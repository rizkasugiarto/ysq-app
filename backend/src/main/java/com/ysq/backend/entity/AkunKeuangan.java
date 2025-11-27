package com.ysq.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "akun_keuangan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AkunKeuangan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_akun")
    private Long idAkun;

    @Column(name = "kode", length = 30, nullable = false)
    private String kode;

    @Column(name = "nama", length = 100, nullable = false)
    private String nama;

    @Column(name = "tipe", length = 30, nullable = false)
    private String tipe;
}
