package com.ysq.backend.controller;

import java.util.List;

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

import com.ysq.backend.entity.Kelas;
import com.ysq.backend.repository.KelasRepository;

@RestController
@RequestMapping("/api/kelas")
public class KelasController {

  private final KelasRepository repo;

  public KelasController(KelasRepository repo) {
    this.repo = repo;
  }

  // READ ALL
  @GetMapping
  public List<Kelas> all() {
    return repo.findAll();
  }

  // READ ONE
  @GetMapping("/{id}")
  public ResponseEntity<Kelas> one(@PathVariable("id") Long id) {
    return repo.findById(id).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // CREATE
  @PostMapping
  public ResponseEntity<Kelas> create(@RequestBody Kelas data) {
    // basic guard (opsional)
    if (data.getIdProgram() == null) {
      return ResponseEntity.badRequest().build();
    }
    Kelas saved = repo.save(data);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  // UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<Kelas> update(@PathVariable("id") Long id, @RequestBody Kelas data) {
    return repo.findById(id).map(existing -> {
      // update semua field yang kamu punya di entity Kelas
      existing.setIdProgram(data.getIdProgram());
      existing.setIdPengajar(data.getIdPengajar());
      existing.setNamaKelas(data.getNamaKelas());
      existing.setTingkatan(data.getTingkatan());
      existing.setStatus(data.getStatus());

      Kelas updated = repo.save(existing);
      return ResponseEntity.ok(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
