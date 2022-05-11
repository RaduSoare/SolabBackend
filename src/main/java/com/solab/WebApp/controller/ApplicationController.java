package com.solab.WebApp.controller;

import com.solab.WebApp.model.Application;
import com.solab.WebApp.model.User;
import com.solab.WebApp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public String add(@RequestBody Application application) {
        applicationService.addApplication(application);
        return "New application is added";
    }

    @GetMapping("/{postId}")
    public List<Application> getAllByPostId(@PathVariable int postId) {
        return applicationService.getAllByPostId(postId);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllPosts();
    }

    @DeleteMapping("/{postId}")
    public String delete(@PathVariable int postId) {
        applicationService.deleteAllByPostId(postId);
        return "Applications for post " + postId + " were deleted";
    }
}
