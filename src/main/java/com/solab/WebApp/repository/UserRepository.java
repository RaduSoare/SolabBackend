package com.solab.WebApp.repository;

import com.solab.WebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.name=?1")
    List<User> getCustomUser(String name);

    @Query("select u from User u where u.email=?1")
    Optional<User> getUserByEmail(String email);
}
