package com.s1.gestion_producto.auth;

import com.s1.gestion_producto.config.JwtService;
import com.s1.gestion_producto.exceptions.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")

public class AuthController {

    private final JwtService jwtService;


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        if (request.username().equals("admin") &&
                request.password().equals("12345")) {

            String token = jwtService.generateToken(request.username());
            return Map.of("token", token);
        }

        throw new BusinessRuleException("Credenciales inválidas");
    }
}
