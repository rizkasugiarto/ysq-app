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
@Table(name = "kelas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kelas")
    private Long idKelas;

    @Column(name = "id_program", nullable = false)
    private Long idProgram;

    @Column(name = "id_pengajar")
    private Long idPengajar;

    @Column(name = "nama_kelas", length = 100)
    private String namaKelas;

    @Column(name = "tingkatan", length = 50)
    private String tingkatan;

    @Column(name = "status", length = 20)
    private String status;
}
