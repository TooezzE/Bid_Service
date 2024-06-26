package com.example.applications.controllers;

import com.example.applications.model.dto.JwtRequest;
import com.example.applications.model.dto.RegistrationUserDto;
import com.example.applications.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/auth")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createUser(registrationUserDto);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(Principal principal) {
        //kill token
        return ResponseEntity.ok().build();
    }

}
