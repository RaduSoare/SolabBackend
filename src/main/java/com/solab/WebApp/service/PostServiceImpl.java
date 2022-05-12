package com.solab.WebApp.service;

import com.solab.WebApp.model.Post;
import com.solab.WebApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostsByType(String type) {
        return postRepository.getPostsByType(type);
    }

    @Override
    public Optional<Post> getPostById(int id) {
        return postRepository.findById(id);
    }
}
