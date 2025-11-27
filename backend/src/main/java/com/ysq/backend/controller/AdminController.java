package com.ysq.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysq.backend.entity.User;
import com.ysq.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "http://localhost:5500"
})
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    // =============== API: LIST SEMUA SANTRI ===============
    @GetMapping("/santri")
    public List<Map<String, Object>> getSantri() {

        List<User> santriList = userRepository.findByRole("SANTRI");

        return santriList.stream()
                .map(u -> {
                    Map<String, Object> m = new HashMap<>();
                    m.put("id", u.getId());
                    m.put("email", u.getEmail());
                    m.put("role", u.getRole());
                    return m;
                })
                .collect(Collectors.toList());
    }
}
