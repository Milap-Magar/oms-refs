package oms.com.example.oms;

import oms.com.example.oms.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class RestApiDemoController {
    private List<User> users = new ArrayList<>();

    public RestApiDemoController(){
        users.addAll(List.of(
                new User(1, "admin", "admin@example.com", "password123!", "9840282128"),
                new User(2, "customer", "customer@example.com", "password123!", "9840282129"),
                new User(3, "user", "user@example.com", "password123!", "9840282130")
        ));
    }

    @GetMapping("/all")
    Iterable<User> getUsers(){
        return users;
    }
}
