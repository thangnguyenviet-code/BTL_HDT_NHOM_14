package com.dnu.careerconnect.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobPosting {
    private int jobId;
    private Employer employer;
    private String title;
    private String description;
    private String requirements;
    private LocalDate deadline;
    private String location;
    private String status; // PENDING | APPROVED | CLOSED
    private List<Application> applications = new ArrayList<>();

    public JobPosting() {}

    public JobPosting(int jobId, String title, String description) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.status = "PENDING";
    }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public Employer getEmployer() { return employer; }
    public void setEmployer(Employer employer) { this.employer = employer; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Application> getApplications() { return applications; }
    public void addApplication(Application app) { applications.add(app); }

    @Override
    public String toString() {
        return "JobPosting{" + "jobId=" + jobId + ", title='" + title + '\'' + ", status='" + status + '\'' + '}';
    }
}
