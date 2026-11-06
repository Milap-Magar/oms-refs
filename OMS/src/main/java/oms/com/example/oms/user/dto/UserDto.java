package oms.com.example.oms.user.dto;

public record UserDto(
        long id,
        String fullName,
        String email,
        String password,
        String phone
) {
}
