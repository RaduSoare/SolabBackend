package com.solab.WebApp.service;

import com.solab.WebApp.model.Post;
import com.solab.WebApp.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public Post addPost(Post post);
    public void deletePost(int id);
    public List<Post> getAllPosts();
    public Optional<Post> getPostById(int id);
}
