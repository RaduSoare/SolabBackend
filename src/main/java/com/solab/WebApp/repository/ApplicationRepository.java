package com.solab.WebApp.repository;

import com.solab.WebApp.model.Application;
import com.solab.WebApp.model.EmailInfo;
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

//    @Query("SELECT User.email, Post.postName, Application.applicantMessage, Application.applicantEmail from Application join Post on Post.id=?1 join user on Post.idVolunteer=User.id")
//    @Query("SELECT new com.solab.WebApp.model.EmailInfo(u.email, p.postName, a.applicantMessage, a.applicantEmail) from Application a join Post p on p.id=?1 join User u on p.idVolunteer=u.id")
     @Query("SELECT new com.solab.WebApp.model.EmailInfo(u.email, p.postName) from Post p join User u on p.id=?1 and p.idVolunteer=u.id")
     EmailInfo getEmailInfoFromPostId(int postId);

}
