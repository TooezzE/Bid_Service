package com.example.applications.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {


    @GetMapping
    public void getUserInfo(Principal principal) {
        principal.getName();
    }
}
