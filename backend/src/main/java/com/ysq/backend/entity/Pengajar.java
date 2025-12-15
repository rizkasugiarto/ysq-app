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
@Table(name = "pengajar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pengajar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pengajar")
    private Long idPengajar;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "status", length = 20)
    private String status;
}
