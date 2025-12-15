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
@Table(name = "tugas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tugas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tugas")
    private Long idTugas;

    @Column(name = "id_kelas")
    private Long idKelas;

    @Column(name = "deskripsi", columnDefinition = "text")
    private String deskripsi;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "file_path", length = 255)
    private String filePath;
}

