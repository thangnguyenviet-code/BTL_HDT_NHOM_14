package com.dnu.careerconnect.serviceimpl;

import com.dnu.careerconnect.model.*;
import com.dnu.careerconnect.service.EmployerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryEmployerService implements EmployerService {
    private Map<Integer, JobPosting> jobs;
    private Map<Integer, Application> applications;
    private int jobSeq = 1;

    public InMemoryEmployerService(Map<Integer, JobPosting> jobs,
                                   Map<Integer, Application> applications) {
        this.jobs = jobs;
        this.applications = applications;
    }

    @Override
    public Employer createEmployer(Employer e) {
        // in a real app we'd persist; here just return
        return e;
    }

    @Override
    public JobPosting postJob(JobPosting job) {
        job.setJobId(jobSeq++);
        job.setStatus("APPROVED"); // for demo
        jobs.put(job.getJobId(), job);
        if (job.getEmployer() != null) job.getEmployer().addJobPosting(job);
        return job;
    }

    @Override
    public List<JobPosting> getJobsByEmployer(int employerId) {
        List<JobPosting> out = new ArrayList<>();
        for (JobPosting j : jobs.values()) {
            if (j.getEmployer() != null && j.getEmployer().getEmployerId() == employerId) {
                out.add(j);
            }
        }
        return out;
    }

    @Override
    public void respondToApplication(int applicationId, String status) {
        Application a = applications.get(applicationId);
        if (a != null) {
            a.setStatus(status);
        }
    }
}