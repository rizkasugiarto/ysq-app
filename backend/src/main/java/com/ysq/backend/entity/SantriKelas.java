package com.ysq.backend.entity;

import java.time.LocalDate;

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
@Table(name = "santri_kelas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SantriKelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_santri_kelas")
    private Long idSantriKelas;

    @Column(name = "id_santri")
    private Long idSantri;

    @Column(name = "id_kelas")
    private Long idKelas;

    @Column(name = "tgl_gabung")
    private LocalDate tglGabung;

    @Column(name = "id_program")
    private Integer idProgram;

    @Column(name = "id_pengajar")
    private Integer idPengajar;
}
