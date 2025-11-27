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
@Table(name = "nilai")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nilai")
    private Long idNilai;

    @Column(name = "id_ujian")
    private Long idUjian;

    @Column(name = "id_santri")
    private Long idSantri;

    @Column(name = "skor")
    private Double skor;

    @Column(name = "catatan", columnDefinition = "text")
    private String catatan;
}
