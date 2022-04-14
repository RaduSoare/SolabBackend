package com.solab.WebApp.controller;

import com.solab.WebApp.messageQueue.MessagingConfig;
import com.solab.WebApp.model.Notification;
import com.solab.WebApp.model.Student;
import com.solab.WebApp.model.User;
import com.solab.WebApp.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate template;

    @PostMapping
    public String add(@RequestBody User user) {
        userService.addUser(user);
        return "New user is added";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "User was deleted";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/custom/{suffix}")
    public List<User> getCustomUser(@PathVariable String suffix) {
        return userService.getCustomUser(suffix);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/publish")
    public String publish(@RequestBody Notification notification) {
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.KEY, notification);
        return "Published!";
    }
}
