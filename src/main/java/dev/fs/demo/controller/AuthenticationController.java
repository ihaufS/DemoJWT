package dev.fs.demo.controller;

import dev.fs.demo.dto.LoginDTO;
import dev.fs.demo.dto.RegisterDTO;
import dev.fs.demo.model.Token;
import dev.fs.demo.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Token> register(
            @RequestBody RegisterDTO request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(
            @RequestBody LoginDTO request
    ) {
        return ResponseEntity.ok(authenticationService.login(request));
    }


}
