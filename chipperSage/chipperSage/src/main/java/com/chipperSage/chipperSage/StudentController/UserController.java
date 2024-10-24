package com.chipperSage.chipperSage.StudentController;

import com.chipperSage.chipperSage.Model.User;
import com.chipperSage.chipperSage.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<User> list() {
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }
}
