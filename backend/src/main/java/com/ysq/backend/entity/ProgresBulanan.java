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
@Table(name = "progres_bulanan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgresBulanan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progres")
    private Long idProgres;

    @Column(name = "id_santri")
    private Long idSantri;

    @Column(name = "id_kelas")
    private Long idKelas;

    @Column(name = "bulan")
    private Integer bulan;

    @Column(name = "nilai_tajwid")
    private Double nilaiTajwid;

    @Column(name = "catatan", columnDefinition = "text")
    private String catatan;

    @Column(name = "status", length = 20)
    private String status;
}
