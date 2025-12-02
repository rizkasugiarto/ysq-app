package com.ysq.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5500")
public class AdminController {

    // Endpoint sederhana buat cek admin API hidup
    @GetMapping("/info")
    public Map<String, String> info() {
        Map<String, String> resp = new HashMap<>();
        resp.put("app", "YSQ Backend");
        resp.put("module", "Admin");
        resp.put("status", "OK");
        return resp;
    }
}
