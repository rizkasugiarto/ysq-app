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
@Table(name = "tagihan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tagihan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tagihan")
    private Long idTagihan;

    @Column(name = "id_program")
    private Long idProgram;

    @Column(name = "periode", length = 30)
    private String periode;

    @Column(name = "nominal")
    private Double nominal;

    @Column(name = "status", length = 20)
    private String status;
}
