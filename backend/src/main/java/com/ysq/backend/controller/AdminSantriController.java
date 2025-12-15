package com.ysq.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysq.backend.entity.Santri;
import com.ysq.backend.repository.SantriRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AdminSantriController {

    private final SantriRepository santriRepository;

    public AdminSantriController(SantriRepository santriRepository) {
        this.santriRepository = santriRepository;
    }

    // GET: /api/admin/santri
    @GetMapping("/santri")
    public List<Santri> getAllSantri() {
        return santriRepository.findAll();
    }
}
