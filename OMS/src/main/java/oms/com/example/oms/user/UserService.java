package oms.com.example.oms.user;

import oms.com.example.oms.common.exception.auth.UserNotFound;
import oms.com.example.oms.user.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // calling out the repo for db-services
    private final UserRepository userRepository;;

    // constructor
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // fetching users all
    public Page<UserResponseDto> fetchUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(u -> new UserResponseDto(
                u.getId(),
                u.getFullName(),
                u.getEmail(),
                u.getPhone()
        ));
    }

    // creating the endpoints basically id based
    public UserResponseDto userById(long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("user not found with id: " + id));
        // success case
        return new UserResponseDto(user.getId(), user.getFullName(), user.getEmail(), user.getPhone());
    };
}