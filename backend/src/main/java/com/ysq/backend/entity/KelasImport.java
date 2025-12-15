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
@Table(name = "kelas_import")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelasImport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kelas_import")
    private Long idKelasImport;

    @Column(name = "pengajar", columnDefinition = "text")
    private String pengajar;

    @Column(name = "jenjang", columnDefinition = "text")
    private String jenjang;

    @Column(name = "kelas", columnDefinition = "text")
    private String kelas;

    @Column(name = "hari", columnDefinition = "text")
    private String hari;

    @Column(name = "waktu", columnDefinition = "text")
    private String waktu;
}
