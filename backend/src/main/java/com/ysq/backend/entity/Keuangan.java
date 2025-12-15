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
@Table(name = "keuangan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Keuangan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_keuangan")
    private Long idKeuangan;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_akun")
    private Long idAkun;

    @Column(name = "jenis_transaksi", length = 30)
    private String jenisTransaksi;

    @Column(name = "deskripsi", length = 255)
    private String deskripsi;

    @Column(name = "nominal")
    private Double nominal;
}
