package com.commerceplatform.api.accounts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.OK).body("Accountss /test");
    }
}

