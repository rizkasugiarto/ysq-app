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
@Table(name = "soal_ujian")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoalUjian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_soal")
    private Long idSoal;

    @Column(name = "id_ujian")
    private Long idUjian;

    @Column(name = "tipe_soal", length = 30)
    private String tipeSoal;

    @Column(name = "pertanyaan", columnDefinition = "text")
    private String pertanyaan;

    @Column(name = "kunci_jawaban", columnDefinition = "text")
    private String kunciJawaban;
}
