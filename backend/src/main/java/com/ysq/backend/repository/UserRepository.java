package com.ysq.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysq.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // dipakai AuthController untuk login
    Optional<User> findByEmail(String email);

    // ambil semua user dengan role tertentu (PENGAJAR, ADMIN, dll)
    @Query("SELECT u FROM User u WHERE LOWER(u.role) = LOWER(:role)")
    List<User> findByRoleIgnoreCase(@Param("role") String role);

    // hitung jumlah user per role (untuk dashboard admin)
    @Query("SELECT COUNT(u) FROM User u WHERE LOWER(u.role) = LOWER(:role)")
    long countByRoleIgnoreCase(@Param("role") String role);
}
