package oms.com.example.oms.auth;

import oms.com.example.oms.auth.dto.LoginDto;
import oms.com.example.oms.auth.dto.LoginResponseDto;
import oms.com.example.oms.auth.dto.RegisterDto;
import oms.com.example.oms.auth.dto.RegisterResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // register mapping
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(
            @Valid @RequestBody RegisterDto registerDto
    ) {
        RegisterResponseDto response = authService.register(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // login mapping
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginDto loginDto
    ) {
        LoginResponseDto response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }
}
