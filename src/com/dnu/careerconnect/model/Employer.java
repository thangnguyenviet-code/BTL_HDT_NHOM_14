package com.dnu.careerconnect.model;

import java.util.ArrayList;
import java.util.List;

public class Employer extends User {
    private int employerId;
    private String companyName;
    private String field;
    private List<JobPosting> jobPostings = new ArrayList<>();

    public Employer() { this.setRole("EMPLOYER"); }

    public Employer(int employerId, String companyName, String field) {
        super();
        this.setRole("EMPLOYER");
        this.employerId = employerId;
        this.companyName = companyName;
        this.field = field;
    }

    public int getEmployerId() { return employerId; }
    public void setEmployerId(int employerId) { this.employerId = employerId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public List<JobPosting> getJobPostings() { return jobPostings; }
    public void addJobPosting(JobPosting job) { jobPostings.add(job); }

    @Override
    public String toString() {
        return "Employer{" + "employerId=" + employerId + ", companyName='" + companyName + '\'' + '}';
    }
}
