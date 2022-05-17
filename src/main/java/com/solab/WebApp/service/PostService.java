package com.solab.WebApp.service;

import com.solab.WebApp.model.Post;
import com.solab.WebApp.model.PostFE;
import com.solab.WebApp.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public Post addPost(Post post);
    public void deletePost(int id);
    public List<Post> getAllPosts();
    public List<Post> getPostsByType(String type);
    public List<Post> getUsersPostByType(String type, String email);
    public List<Post> getUsersPost(String email);
    public Optional<Post> getPostById(int id);
    public Post createNewPost(PostFE postFE);
}
