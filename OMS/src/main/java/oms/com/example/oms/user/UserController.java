package oms.com.example.oms.user;

import oms.com.example.oms.user.dto.UserResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    // controller
    public UserController(UserService userService){
        this.userService = userService;
    }

    //route mapping
    @GetMapping("/{id}")
    public UserResponseDto getUserById(
            @PathVariable Long id
    ){
        return userService.userById(id);
    }
}
