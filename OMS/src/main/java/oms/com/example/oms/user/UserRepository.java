package oms.com.example.oms.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import oms.com.example.oms.auth.dto.LoginResponseDto;
import oms.com.example.oms.user.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(@NotBlank @Email String email);

    Optional <User> findByEmail(String email);
}
