package com.solab.WebApp.service;

import com.solab.WebApp.messageQueue.MessagingConfig;
import com.solab.WebApp.model.Application;
import com.solab.WebApp.model.EmailInfo;
import com.solab.WebApp.repository.ApplicationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private RabbitTemplate template;

    @Override
    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void publishApplication(Application application) {
        EmailInfo tempEmailInfo = getEmailInfo(application.getPostId());
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.KEY, new EmailInfo(tempEmailInfo.getVolunteerEmail(), tempEmailInfo.getPostName(), application));
    }

    public EmailInfo getEmailInfo(int postId) {
        return applicationRepository.getEmailInfoFromPostId(postId);
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
