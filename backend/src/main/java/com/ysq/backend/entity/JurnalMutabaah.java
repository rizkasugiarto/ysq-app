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
@Table(name = "jurnal_mutabaah")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JurnalMutabaah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jurnal")
    private Long idJurnal;

    @Column(name = "id_santri", nullable = false)
    private Long idSantri;

    @Column(name = "id_kelas", nullable = false)
    private Long idKelas;

    @Column(name = "periode", length = 30)
    private String periode;

    @Column(name = "ringkasan", columnDefinition = "text")
    private String ringkasan;

    @Column(name = "poin")
    private Integer poin;
}
