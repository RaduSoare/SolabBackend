package com.solab.WebApp.service;

import com.solab.WebApp.model.Application;
import com.solab.WebApp.model.Post;

import java.util.List;

public interface ApplicationService {
    public Application addApplication(Application application);
    public void deleteAllByPostId(int id);
    public List<Application> getAllByPostId(int id);
    public List<Application> getAllApplications();



}
