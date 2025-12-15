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
@Table(name = "pembayaran")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pembayaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembayaran")
    private Long idPembayaran;

    @Column(name = "id_tagihan")
    private Long idTagihan;

    @Column(name = "id_santri")
    private Long idSantri;

    @Column(name = "tanggal_bayar")
    private LocalDate tanggalBayar;

    @Column(name = "nominal")
    private Double nominal;

    @Column(name = "bukti_path", length = 255)
    private String buktiPath;
}
