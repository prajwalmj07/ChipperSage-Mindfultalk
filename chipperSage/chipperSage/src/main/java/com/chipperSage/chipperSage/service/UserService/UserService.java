package com.chipperSage.chipperSage.service.UserService;

import com.chipperSage.chipperSage.Model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int id);
}
