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

    @PostMapping
    public ResponseEntity<Post> add(@RequestBody PostFE postFE) {
        Post newPost = postService.createNewPost(postFE);
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

    @GetMapping("type/{serviceType}")
    public List<Post> getPostsByType(@PathVariable String serviceType) {
        return postService.getPostsByType(serviceType);
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

}
