package com.solab.WebApp.controller;

import com.solab.WebApp.model.Post;
import com.solab.WebApp.model.PostFE;
import com.solab.WebApp.model.User;
import com.solab.WebApp.service.PostService;
import com.solab.WebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Post> add(@RequestBody PostFE postFE) {
        System.out.println(postFE.getUserEmail());
        User user = userService.getUserByEmail(postFE.getUserEmail()).get();
        Post newPost = postService.addPost(new Post(user.getId(), postFE.getPostName(), postFE.getType(), postFE.getData()));
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        postService.deletePost(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getUserById(@PathVariable int id) {
        return postService.getPostById(id);
    }

}
