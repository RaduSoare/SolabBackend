package com.solab.WebApp.service;

import com.solab.WebApp.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User addUser(User user);
    public void deleteUser(int id);
    public List<User> getAllUsers();
    public Optional<User> getUserById(int id);
    public Optional<User> getUserByEmail(String email);
    public List<User> getCustomUser(String name);
}
