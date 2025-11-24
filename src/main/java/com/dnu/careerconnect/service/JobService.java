package com.dnu.careerconnect.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dnu.careerconnect.model.JobPosting;

@Service
public class JobService {
    private Map<Integer, JobPosting> jobs = new HashMap<>();
    private int seq = 1;

    public JobPosting postJob(String title, String description, String employerName) {
        JobPosting job = new JobPosting(seq++, title, description, employerName);
        job.setStatus("APPROVED"); 
        jobs.put(job.getId(), job);
        return job;
    }
    public Collection<JobPosting> getAllJobs() {
        return jobs.values();
    }
    public JobPosting getJob(int id) {
        return jobs.get(id);
    }
    public void deleteJob(int jobId) {
        jobs.remove(jobId);
    }
}