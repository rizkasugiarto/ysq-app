package com.ysq.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ysq.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // dipakai untuk login
    User findByEmail(String email);

    // kalau mau ambil semua user dengan role tertentu
    List<User> findByRole(String role);
}
