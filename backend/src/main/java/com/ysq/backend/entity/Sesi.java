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
@Table(name = "sesi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sesi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesi")
    private Long idSesi;

    @Column(name = "id_jadwal")
    private Long idJadwal;

    @Column(name = "tgl_sesi")
    private LocalDate tglSesi;

    @Column(name = "topik", length = 150)
    private String topik;

    @Column(name = "id_kurikulum")
    private Long idKurikulum;
}
