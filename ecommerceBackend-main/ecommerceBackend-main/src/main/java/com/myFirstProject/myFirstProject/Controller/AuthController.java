package com.myFirstProject.myFirstProject.Controller;


import com.myFirstProject.myFirstProject.DTO.AuthResponse;
import com.myFirstProject.myFirstProject.DTO.LoginRequest;
import com.myFirstProject.myFirstProject.DTO.RegisterRequest;
import com.myFirstProject.myFirstProject.Repository.UserRepository;
import com.myFirstProject.myFirstProject.Service.UserService;
import com.myFirstProject.myFirstProject.entity.Users;
import com.myFirstProject.myFirstProject.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String identifier = normalize(loginRequest.getEmail());
        if (identifier == null) {
            identifier = normalize(loginRequest.getUsername());
        }

        if (identifier == null || isBlank(loginRequest.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email or username and password are required");
        }

        Optional<Users> userOptional = userRepository.findByEmail(identifier);
        if (userOptional.isEmpty()) {
            userOptional = userRepository.findByName(identifier);
        }

        Users user = userOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getId());
        return ResponseEntity.ok(buildAuthResponse("Login successful", token, user));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        String email = normalize(registerRequest.getEmail());
        String name = normalize(registerRequest.getName());
        if (name == null) {
            name = normalize(registerRequest.getUsername());
        }

        if (name == null || email == null || isBlank(registerRequest.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name, email, and password are required");
        }

        if (userRepository.findByEmail(email).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        Users newUser = new Users();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setRole("USER");

        Users savedUser = userRepository.save(newUser);
        userService.add(savedUser);

        String token = jwtUtil.generateToken(savedUser.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(buildAuthResponse("User registered successfully", token, savedUser));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody RegisterRequest registerRequest) {
        return register(registerRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
        return login(loginRequest);
    }

    private AuthResponse buildAuthResponse(String message, String token, Users user) {
        AuthResponse response = new AuthResponse();
        response.setMessage(message);
        response.setToken(token);
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }

    private String normalize(String value) {
        if (value == null) {
            return null;
        }

        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

}
