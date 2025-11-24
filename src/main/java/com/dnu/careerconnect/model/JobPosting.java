package com.dnu.careerconnect.model;

import java.util.ArrayList;
import java.util.List;

public class JobPosting {
    private int id;
    private String title;
    private String description;
    private String employerName;
    private String status; 
    private List<Application> applications = new ArrayList<>();
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public JobPosting() {}
    public JobPosting(int id, String title, String description, String employerName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.employerName = employerName;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getEmployerName() { return employerName; }
    public List<Application> getApplications() { return applications; }
    public void addApplication(Application app) { applications.add(app); }
}