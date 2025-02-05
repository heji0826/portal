package com.example.portal.controller;

import com.example.portal.dto.LoginRequest;
import com.example.portal.entity.User;
import com.example.portal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        return authService.authenticate(username, password) ? 
               ResponseEntity.ok("yes") : 
               ResponseEntity.status(401).body("no");
    }

    // 사용자 추가
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestParam String username, @RequestParam String password) {
        User user = authService.addUser(username, password);
        return ResponseEntity.ok(user);
    }

    // 사용자 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        authService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // 모든 사용자 조회
    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Authentication Service is healthy");
    }
}
