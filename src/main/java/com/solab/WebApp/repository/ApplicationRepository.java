package com.solab.WebApp.repository;

import com.solab.WebApp.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Application where postId=?1")
    void deleteByPostId(int postId);

    @Query("select a from Application a where postId=?1")
    List<Application> getAllByPostId(int postId);
}
