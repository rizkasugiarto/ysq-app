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
@Table(name = "event_peserta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventPeserta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event_peserta")
    private Long idEventPeserta;

    @Column(name = "id_event", nullable = false)
    private Long idEvent;

    @Column(name = "id_santri", nullable = false)
    private Long idSantri;

    @Column(name = "peran", length = 30)
    private String peran;
}
