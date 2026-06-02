package com.bake.bake_backend.service;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bake.bake_backend.entity.User;
import com.bake.bake_backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public Map<String, String> register(String name, String email, String password) {
        if (userRepository.existsByEmail(email))
            throw new RuntimeException("Email đã được sử dụng!");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(User.Role.USER);
        userRepository.save(user);

        String token = jwtUtil.generateToken(email, "USER");
        return Map.of("token", token, "role", "USER", "name", name);
    }

    public Map<String, String> login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email không tồn tại!"));

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new RuntimeException("Mật khẩu không đúng!");

        String token = jwtUtil.generateToken(email, user.getRole().name());
        return Map.of("token", token, "role", user.getRole().name(), "name", user.getName());
    }
}