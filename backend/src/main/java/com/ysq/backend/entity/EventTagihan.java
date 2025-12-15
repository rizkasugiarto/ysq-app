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
@Table(name = "event_tagihan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventTagihan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event_tagihan")
    private Long idEventTagihan;

    @Column(name = "id_event", nullable = false)
    private Long idEvent;

    @Column(name = "id_tagihan", nullable = false)
    private Long idTagihan;
}
