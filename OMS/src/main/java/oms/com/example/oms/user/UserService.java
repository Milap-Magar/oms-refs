package oms.com.example.oms.user;

import oms.com.example.oms.common.exception.UserNotFound;
import oms.com.example.oms.user.dto.UserDto;
import oms.com.example.oms.user.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    // calling out the repo for db-services
    private final UserRepository userRepository;

    // constructor
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // creating the endpoints basically id based
    public UserResponseDto userById(long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("user not found with id: " + id));
        // success case
        return new UserResponseDto(user.getId(), user.getFullName(), user.getEmail(), user.getPhone());
    };
}
