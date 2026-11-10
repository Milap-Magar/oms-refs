package oms.com.example.oms.user;

import oms.com.example.oms.user.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    // controller
    public UserController(UserService userService){
        this.userService = userService;
    }

    // fetch all datasets
    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.fetchUsers(pageable));
    }

    //route mapping
    @GetMapping("/{id}")
    public UserResponseDto getUserById(
            @PathVariable Long id
    ){
        return userService.userById(id);
    }

    // add category
//    @PostMapping
}
