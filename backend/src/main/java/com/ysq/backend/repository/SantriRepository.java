package com.ysq.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ysq.backend.entity.Santri;

@Repository
public interface SantriRepository extends JpaRepository<Santri, Long> {

    // cari santri berdasarkan userId (kolom id di tabel santri)
    Santri findByUserId(Long userId);
}
