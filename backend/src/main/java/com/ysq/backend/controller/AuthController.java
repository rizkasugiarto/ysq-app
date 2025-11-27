package com.ysq.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysq.backend.entity.User;
import com.ysq.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "http://localhost:5500"
})
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ====================== REGISTER SANTRI ======================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        if (email == null || password == null ||
                email.isBlank() || password.isBlank()) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "success", false,
                            "message", "Email dan password wajib diisi"
                    )
            );
        }

        // Cek apakah email sudah ada
        User existing = userRepository.findByEmail(email);
        if (existing != null) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "success", false,
                            "message", "Email sudah terdaftar"
                    )
            );
        }

        // Simpan user baru
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // (bisa diganti hash nanti)
        user.setRole("SANTRI");

        userRepository.save(user);

        return ResponseEntity.ok(
                Map.of(
                        "success", true,
                        "message", "Registrasi berhasil! Silakan cek informasi selanjutnya."
                )
        );
    }

    // ====================== LOGIN ======================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        if (email == null || password == null ||
                email.isBlank() || password.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of(
                            "success", false,
                            "message", "Email dan password wajib diisi"
                    ));
        }

        User user = userRepository.findByEmail(email);

        // Jika email tidak ditemukan
        if (user == null) {
            return ResponseEntity
                    .status(401)
                    .body(Map.of(
                            "success", false,
                            "message", "Email tidak ditemukan"
                    ));
        }

        // Cek password
        if (!user.getPassword().equals(password)) {
            return ResponseEntity
                    .status(401)
                    .body(Map.of(
                            "success", false,
                            "message", "Password salah"
                    ));
        }

        // Jika berhasil login
        return ResponseEntity.ok(
                Map.of(
                        "success", true,
                        "message", "Login berhasil",
                        "role", user.getRole()
                )
        );
    }
}
