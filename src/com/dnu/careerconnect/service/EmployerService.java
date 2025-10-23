package com.dnu.careerconnect.service;

import com.dnu.careerconnect.model.Employer;
import com.dnu.careerconnect.model.JobPosting;

import java.util.List;

public interface EmployerService {
    Employer createEmployer(Employer e);
    JobPosting postJob(JobPosting job);
    List<JobPosting> getJobsByEmployer(int employerId);
    void respondToApplication(int applicationId, String status);
}