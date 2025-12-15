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
@Table(name = "tarif_gaji_pengajar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifGajiPengajar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarif")
    private Long idTarif;

    @Column(name = "id_program")
    private Long idProgram;

    @Column(name = "id_pengajar")
    private Long idPengajar;

    @Column(name = "jenis_tarif", length = 30)
    private String jenisTarif;

    @Column(name = "nominal")
    private Double nominal;

    @Column(name = "aktif")
    private Boolean aktif;
}
