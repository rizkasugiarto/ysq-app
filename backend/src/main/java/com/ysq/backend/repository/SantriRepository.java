package com.ysq.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysq.backend.entity.Santri;

public interface SantriRepository extends JpaRepository<Santri, Long> {
    // CRUD default saja
}
