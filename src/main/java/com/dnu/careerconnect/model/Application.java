package com.dnu.careerconnect.model;

import java.time.LocalDate;

public class Application {
    private int id;
    private Student student;      
    private JobPosting job;      
    private LocalDate applyDate;
    private String status;        

    public Application() {}
    public Application(int id, Student student, JobPosting job) {
        this.id = id;
        this.student = student;
        this.job = job;
        this.applyDate = LocalDate.now();
        this.status = "PENDING";
    }

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public JobPosting getJob() { return job; }
    public LocalDate getApplyDate() { return applyDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}