package com.ysq.backend.entity;

import java.time.LocalTime;

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
@Table(name = "jadwal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jadwal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jadwal")
    private Long idJadwal;

    @Column(name = "id_kelas", nullable = false)
    private Long idKelas;

    @Column(name = "hari", length = 15)
    private String hari;

    @Column(name = "jam_mulai")
    private LocalTime jamMulai;

    @Column(name = "jam_selesai")
    private LocalTime jamSelesai;
}
