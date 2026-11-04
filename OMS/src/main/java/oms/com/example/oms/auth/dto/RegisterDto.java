package oms.com.example.oms.auth.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Just the register Dto segmentations
public record RegisterDto(
        @NotBlank String fullName,
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotBlank String phone
) {
}
