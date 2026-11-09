package oms.com.example.oms.user;

import oms.com.example.oms.common.exception.UserNotFound;
import oms.com.example.oms.user.dto.UserResponseDto;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    // calling out the repo for db-services
    private final UserRepository userRepository;;

    // constructor
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    // fetching users all
    public Page<UserResponseDto> users(Pageable pageable) {
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