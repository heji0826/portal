package com.example.portal.service;

import com.example.portal.entity.User;
import com.example.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 사용자 인증 (로그인)
    public boolean authenticate(String username, String rawPassword) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            return false; // 사용자가 존재하지 않음
        }

        User user = userOpt.get();
        return passwordEncoder.matches(rawPassword, user.getPassword()); // 비밀번호 검증
    }

    // 사용자 추가 (회원가입)
    public User addUser(String username, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword)); // 비밀번호 암호화
        return userRepository.save(user);
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // 모든 사용자 조회
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
