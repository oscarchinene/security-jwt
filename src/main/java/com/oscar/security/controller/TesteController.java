package com.oscar.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TesteController {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Testando Segurança");
    }
}
