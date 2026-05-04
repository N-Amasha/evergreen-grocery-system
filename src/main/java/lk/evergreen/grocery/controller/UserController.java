package lk.evergreen.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.service.UserService;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }
}
