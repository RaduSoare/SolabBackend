package com.solab.WebApp.service;

import com.solab.WebApp.model.Application;
import com.solab.WebApp.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void deleteAllByPostId(int id) {
        applicationRepository.deleteByPostId(id);
    }

    @Override
    public List<Application> getAllByPostId(int id) {
        return applicationRepository.getAllByPostId(id);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}
