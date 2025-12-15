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
@Table(name = "kurikulum")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kurikulum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kurikulum")
    private Long idKurikulum;

    @Column(name = "id_program")
    private Long idProgram;

    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "deskripsi", columnDefinition = "text")
    private String deskripsi;
}
