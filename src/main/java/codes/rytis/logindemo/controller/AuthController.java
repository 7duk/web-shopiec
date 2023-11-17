package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.login.LoginDto;
import codes.rytis.logindemo.dto.token.TokenDto;
import codes.rytis.logindemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody @Validated LoginDto request) {
        System.out.println(request.toString());
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

}
