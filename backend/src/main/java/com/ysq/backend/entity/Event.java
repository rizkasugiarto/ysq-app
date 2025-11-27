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
@Table(name = "event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Long idEvent;

    @Column(name = "nama", length = 120, nullable = false)
    private String nama;

    @Column(name = "tanggal")
    private LocalDate tanggal;

    @Column(name = "lokasi", length = 150)
    private String lokasi;

    @Column(name = "berbiaya")
    private Boolean berbiaya;

    @Column(name = "keterangan", columnDefinition = "text")
    private String keterangan;
}
