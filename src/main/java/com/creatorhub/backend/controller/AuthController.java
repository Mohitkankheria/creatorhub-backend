package com.creatorhub.backend.controller;

import com.creatorhub.backend.dto.SignupRequest;
import com.creatorhub.backend.dto.SignupResponse;
import com.creatorhub.backend.entity.User;
import com.creatorhub.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public SignupResponse signup(@Valid @RequestBody SignupRequest request) {

        return authService.signup(request);
    }
}