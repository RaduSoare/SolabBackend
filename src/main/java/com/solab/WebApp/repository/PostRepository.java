package com.solab.WebApp.repository;

import com.solab.WebApp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p where serviceType=?1")
    List<Post> getPostsByType(String type);

    @Query("select p from Post p where serviceType=?1 and idVolunteer=?2")
    List<Post> getUsersPostByType(String type, int id);

    @Query("select p from Post p where idVolunteer=?1")
    List<Post> getUsersPost(int id);
}
