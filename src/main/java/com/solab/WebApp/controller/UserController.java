package com.solab.WebApp.controller;

import com.solab.WebApp.messageQueue.MessagingConfig;
import com.solab.WebApp.model.Notification;
import com.solab.WebApp.model.Student;
import com.solab.WebApp.model.User;
import com.solab.WebApp.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import java.security.interfaces.RSAPublicKey;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate template;

    @PostMapping
    public String add(@RequestBody User user) {
        try {
            User userAdded = userService.addUser(user);
            return "New user is added";
        } catch (DataIntegrityViolationException exception) {
            return "Nasol";
        }

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "User was deleted";
    }

//    @GetMapping
//    public List<User> getAllUsers(@RequestHeader("Authorization") String bearerToken) {
//        Base64.Decoder decoder = Base64.getUrlDecoder();
//        String token = bearerToken.split(" ")[1];
//        String[] chunks = token.split("\\.");
////        System.out.println(token);
////        String payload = new String(decoder.decode(token.split("\\.")[1]));
////        System.out.println(payload);
//        String secretKey = "dIKCIIaZIGo95YuqhG5w6wPfdt4HB45jPDewvHxACiYmsSMHdTDdOdi8tSPwWsQp";
//        SignatureAlgorithm sa = SignatureAlgorithm.RS256
//        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), sa.getJcaName());
//        String tokenWithoutSignature = chunks[0] + "." + chunks[1];
//        String signature = chunks[2];
//
//        DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(sa, secretKeySpec);
//
//        if (!validator.isValid(tokenWithoutSignature, signature)) {
//            System.out.println("Token prost");
//        } else {
//            System.out.println("Token bun");
//        }
//
//        return userService.getAllUsers();
//    }
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
