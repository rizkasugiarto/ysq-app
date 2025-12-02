package com.ysq.backend.controller;

import com.ysq.backend.entity.Santri;
import com.ysq.backend.entity.User;
import com.ysq.backend.repository.SantriRepository;
import com.ysq.backend.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/santri")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SantriController {

    private final UserRepository userRepository;
    private final SantriRepository santriRepository;

    public SantriController(UserRepository userRepository,
                            SantriRepository santriRepository) {
        this.userRepository = userRepository;
        this.santriRepository = santriRepository;
    }

    // GET: /api/santri/dashboard?email=...
    @GetMapping("/dashboard")
    public Map<String, Object> getSantriDashboard(@RequestParam String email) {

        Map<String, Object> result = new HashMap<>();

        // 1. cari user berdasarkan email
        User user = userRepository.findByEmail(email);
        if (user == null) {
            result.put("error", "User tidak ditemukan");
            return result;
        }

        // 2. cari santri berdasarkan userId (kolom id di tabel santri)
        Santri santri = santriRepository.findByUserId(user.getId());
        if (santri == null) {
            result.put("error", "Data santri tidak ditemukan untuk user ini");
            return result;
        }

        // 3. kirim data ke frontend
        result.put("idSantri", santri.getIdSantri());
        result.put("nama", santri.getNama());
        result.put("kategori", santri.getKategori());
        result.put("status", santri.getStatus());
        result.put("kelas", santri.getKelas());
        result.put("noWa", santri.getNoWa());
        result.put("alamat", santri.getAlamat());

        return result;
    }
}
