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
@Table(name = "ujian")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ujian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ujian")
    private Long idUjian;

    @Column(name = "id_kelas")
    private Long idKelas;

    @Column(name = "nama_ujian", length = 100)
    private String namaUjian;

    @Column(name = "tipe", length = 30)
    private String tipe;

    @Column(name = "bobot")
    private Double bobot;
}
