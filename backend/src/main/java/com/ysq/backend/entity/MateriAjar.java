package com.ysq.backend.entity;

import java.time.LocalDateTime;

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
@Table(name = "materi_ajar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriAjar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materi")
    private Long idMateri;

    @Column(name = "id_kelas")
    private Long idKelas;

    @Column(name = "judul", length = 150)
    private String judul;

    @Column(name = "tipe_file", length = 30)
    private String tipeFile;

    @Column(name = "path", length = 255)
    private String path;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
}
