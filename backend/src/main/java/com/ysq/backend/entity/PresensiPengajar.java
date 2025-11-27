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
@Table(name = "presensi_pengajar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PresensiPengajar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presensi_pengajar")
    private Long idPresensiPengajar;

    @Column(name = "id_sesi")
    private Long idSesi;

    @Column(name = "id_pengajar")
    private Long idPengajar;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "catatan", columnDefinition = "text")
    private String catatan;
}
