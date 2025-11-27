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
@Table(name = "infaq_non_iuran")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfaqNonIuran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_infaq")
    private Long idInfaq;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "id_program", nullable = false)
    private Long idProgram;

    @Column(name = "tanggal")
    private LocalDate tanggal;

    @Column(name = "nominal")
    private Double nominal;

    @Column(name = "catatan", columnDefinition = "text")
    private String catatan;
}
