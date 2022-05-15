package com.solab.WebApp.model;

import javax.persistence.Entity;


public class EmailInfo {
    private String volunteerEmail;
    private String postName;
    private String applicantEmail;
    private String applicantMessage;


//    public EmailInfo() {
//    }

    public EmailInfo(String volunteerEmail, String postName) {
        this.volunteerEmail = volunteerEmail;
        this.postName = postName;
    }

    public EmailInfo(String volunteerEmail, String postName, Application application) {
        this.volunteerEmail = volunteerEmail;
        this.postName = postName;
        this.applicantEmail = application.getApplicantEmail();
        this.applicantMessage = application.getApplicantMessage();
    }

    public String getVolunteerEmail() {
        return volunteerEmail;
    }

    public void setVolunteerEmail(String volunteerEmail) {
        this.volunteerEmail = volunteerEmail;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantMessage() {
        return applicantMessage;
    }

    public void setApplicantMessage(String applicantMessage) {
        this.applicantMessage = applicantMessage;
    }
}
