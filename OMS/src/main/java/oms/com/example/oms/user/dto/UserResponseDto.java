package oms.com.example.oms.user.dto;

public record UserResponseDto(
        long id,
        String fullName,
        String email,
        String phone
) {
}
