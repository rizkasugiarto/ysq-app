package com.ysq.backend.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ysq.backend.entity.User;
import com.ysq.backend.repository.UserRepository;
import com.ysq.backend.dto.LoginRequest;
import com.ysq.backend.dto.LoginResponse;
import com.ysq.backend.dto.MessageResponse;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5500")
public class AuthController {

    private final UserRepository userRepository;

    // constructor injection
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // 1. cek input kosong
        if (request.getEmail() == null || request.getEmail().isBlank()
                || request.getPassword() == null || request.getPassword().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Email dan password wajib diisi"));
        }

        // 2. cari user berdasarkan email (hasil Optional<User>)
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        // kalau user tidak ditemukan
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("Email atau password salah"));
        }

        User user = optionalUser.get();

        // 3. cek password sederhana (belum pakai hashing)
        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("Email atau password salah"));
        }

        // 4. susun response untuk frontend
        LoginResponse res = new LoginResponse();
        res.setEmail(user.getEmail());
        res.setRole(user.getRole());

        return ResponseEntity.ok(res);
    }
}
