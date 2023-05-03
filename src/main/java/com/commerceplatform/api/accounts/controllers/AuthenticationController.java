package com.commerceplatform.api.accounts.controllers;

import com.commerceplatform.api.accounts.dtos.inputs.LoginInput;
import com.commerceplatform.api.accounts.dtos.outputs.LoginOutput;
import com.commerceplatform.api.accounts.security.JwtService;
import com.commerceplatform.api.accounts.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginOutput> login(@RequestBody LoginInput loginInput) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.login(loginInput));
    }

    @GetMapping("/validate-token")
    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
        jwtService.validateJwt(token);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
