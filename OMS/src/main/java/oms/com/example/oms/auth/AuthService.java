package oms.com.example.oms.auth;

import oms.com.example.oms.auth.dto.LoginDto;
import oms.com.example.oms.auth.dto.LoginResponseDto;
import oms.com.example.oms.auth.dto.RegisterDto;
import oms.com.example.oms.auth.dto.RegisterResponseDto;
import oms.com.example.oms.common.exception.EmailAlreadyExists;
import oms.com.example.oms.common.exception.InvalidCredentialsException;
import oms.com.example.oms.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // register services business handler
    public RegisterResponseDto register(RegisterDto request) {

        if (authRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExists("Email is already registered");
        }

        User user = new User();
        user.setEmail(request.email());
        user.setFullName(request.fullName());
        user.setPhone(request.phone());
        user.setPassword(passwordEncoder.encode(request.password()));

        authRepository.save(user);
        return new RegisterResponseDto("User registered successfully", false);
    }

    // login services business handler
    public LoginResponseDto login(LoginDto request) {

        User user = authRepository
                .findByEmail(request.email())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        return new LoginResponseDto(
                "verified",
                false,
                UUID.randomUUID(),
                "admin"
        );
    }
}
