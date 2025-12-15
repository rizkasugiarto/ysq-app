package com.ysq.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ysq.backend.entity.Santri;
import com.ysq.backend.repository.SantriRepository;

@RestController
@RequestMapping("/api/santri")
public class SantriController {

  private final SantriRepository repo;

  public SantriController(SantriRepository repo) {
    this.repo = repo;
  }

  // READ ALL
  @GetMapping
  public List<Santri> all() {
    return repo.findAll();
  }

  // READ ONE
  @GetMapping("/{id}")
  public ResponseEntity<Santri> one(@PathVariable Long id) {
    return repo.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // CREATE
  @PostMapping
  public ResponseEntity<?> create(@RequestBody Santri data) {
    if (data.getNama() == null || data.getNama().trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Nama wajib diisi");
    }
    Santri saved = repo.save(data);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  // UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<Santri> update(@PathVariable Long id, @RequestBody Santri data) {
    return repo.findById(id).map(existing -> {
      existing.setNama(data.getNama());
      existing.setAlamat(data.getAlamat());
      existing.setTempatLahir(data.getTempatLahir());
      existing.setTanggalLahir(data.getTanggalLahir());
      existing.setNoWa(data.getNoWa());
      existing.setKategori(data.getKategori());
      return ResponseEntity.ok(repo.save(existing));
    }).orElse(ResponseEntity.notFound().build());
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
