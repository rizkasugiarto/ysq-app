package com.ysq.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysq.backend.entity.User;
import com.ysq.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/pengajar")
public class PengajarController {

    @Autowired
    private UserRepository userRepository;

    // ============ LIST SEMUA PENGAJAR ============
    @GetMapping
    public List<User> getAllPengajar() {
        return userRepository.findByRoleIgnoreCase("PENGAJAR");
    }

    // ============ DETAIL 1 PENGAJAR ============
    @GetMapping("/{id}")
    public ResponseEntity<User> getPengajar(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ============ CREATE PENGAJAR ============
    @PostMapping
    public ResponseEntity<User> createPengajar(@RequestBody User data) {
        // paksa role = PENGAJAR, jangan percaya dari frontend
        data.setRole("PENGAJAR");
        User saved = userRepository.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ============ UPDATE PENGAJAR ============
    @PutMapping("/{id}")
    public ResponseEntity<User> updatePengajar(
            @PathVariable Long id,
            @RequestBody User data) {

        return userRepository.findById(id).map(user -> {
            user.setNama(data.getNama());
            user.setAlamat(data.getAlamat());
            user.setTempatLahir(data.getTempatLahir());
            user.setTanggalLahir(data.getTanggalLahir());
            user.setUmur(data.getUmur());
            user.setMapel(data.getMapel());
            user.setNoWa(data.getNoWa());
            user.setEmail(data.getEmail());

            // kalau mau izinkan update password:
            // user.setPassword(data.getPassword());

            User updated = userRepository.save(user);
            return ResponseEntity.ok(updated);

        }).orElse(ResponseEntity.notFound().build());
    }

    // ============ DELETE PENGAJAR ============
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePengajar(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
