package oms.com.example.oms.auth.dto;

import jakarta.validation.constraints.NotNull;

public record LoginResponseDto(
        String accessToken,
        @NotNull boolean isOnboarding,
        java.util.UUID csrfToken,
        @NotNull String role
) {
}
