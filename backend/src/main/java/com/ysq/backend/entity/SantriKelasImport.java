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
@Table(name = "santri_kelas_import")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SantriKelasImport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_santri_kelas_import")
    private Long idSantriKelasImport;

    @Column(name = "id_kelas_import")
    private Long idKelasImport;

    @Column(name = "sumber", columnDefinition = "text")
    private String sumber;

    @Column(name = "raw_detail", columnDefinition = "text")
    private String rawDetail;
}
