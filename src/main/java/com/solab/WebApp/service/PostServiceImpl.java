package com.solab.WebApp.service;

import com.solab.WebApp.model.Post;
import com.solab.WebApp.model.PostFE;
import com.solab.WebApp.model.User;
import com.solab.WebApp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{


    private final PostRepository postRepository;
    private final UserService userService;

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

    @Override
    public Post createNewPost(PostFE postFE) {
        User user = userService.getUserByEmail(postFE.getUserEmail()).get();
        Post newPost = new Post(user.getId(), postFE.getPostName(), postFE.getType(), postFE.getData());
        return newPost;
    }
}
