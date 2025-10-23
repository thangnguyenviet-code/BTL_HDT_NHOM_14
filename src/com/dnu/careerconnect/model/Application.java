package com.dnu.careerconnect.model;

import java.time.LocalDate;

public class Application {
    private int appId;
    private Student student;
    private JobPosting job;
    private LocalDate applyDate;
    private String status; // PENDING | INTERVIEW | ACCEPTED | REJECTED

    public Application() {}

    public Application(int appId, Student student, JobPosting job) {
        this.appId = appId;
        this.student = student;
        this.job = job;
        this.applyDate = LocalDate.now();
        this.status = "PENDING";
    }

    public int getAppId() { return appId; }
    public void setAppId(int appId) { this.appId = appId; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public JobPosting getJob() { return job; }
    public void setJob(JobPosting job) { this.job = job; }

    public LocalDate getApplyDate() { return applyDate; }
    public void setApplyDate(LocalDate applyDate) { this.applyDate = applyDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Application{" + "appId=" + appId + ", student=" + student.getFullName() +
                ", job=" + job.getTitle() + ", status=" + status + '}';
    }
}