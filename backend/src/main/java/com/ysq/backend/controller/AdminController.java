package com.ysq.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysq.backend.repository.SantriRepository;
import com.ysq.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {
        "http://localhost:5500",
        "http://127.0.0.1:5500"
}) // frontend-ysq
public class AdminController {

    @Autowired
    private SantriRepository santriRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Cek API admin hidup
     * GET: http://localhost:8080/api/admin/info
     */
    @GetMapping("/info")
    public Map<String, String> info() {
        Map<String, String> resp = new HashMap<>();
        resp.put("app", "YSQ Backend");
        resp.put("module", "Admin");
        resp.put("status", "OK");
        return resp;
    }

    /**
     * Data ringkasan untuk dashboard admin
     * GET: http://localhost:8080/api/admin/dashboard
     */
    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardSummary() {
        Map<String, Object> resp = new HashMap<>();

        long totalSantri   = santriRepository.count();
        long totalPengajar = userRepository.countByRoleIgnoreCase("PENGAJAR");
        long totalAdmin    = userRepository.countByRoleIgnoreCase("ADMIN");

        resp.put("totalSantri", totalSantri);
        resp.put("totalPengajar", totalPengajar);
        resp.put("totalAdmin", totalAdmin);
        return resp;
    }
}
