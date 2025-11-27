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
@Table(name = "santri")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Santri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_santri")
    private Long idSantri;

    @Column(name = "nis", length = 30)
    private String nis;

    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "status", length = 20)
    private String status;
}
