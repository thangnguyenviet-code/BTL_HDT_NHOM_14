package com.dnu.careerconnect.serviceimpl;

import com.dnu.careerconnect.model.*;
import com.dnu.careerconnect.service.StudentService;

import java.util.*;

public class InMemoryStudentService implements StudentService {
    private Map<Integer, Student> students = new HashMap<>();
    private Map<Integer, JobPosting> jobs; // shared reference
    private Map<Integer, Application> applications; // global application store
    private int appSeq = 1;

    public InMemoryStudentService(Map<Integer, JobPosting> jobs,
                                  Map<Integer, Application> applications) {
        this.jobs = jobs;
        this.applications = applications;
    }

    @Override
    public Student createProfile(Student s) {
        students.put(s.getStudentId(), s);
        return s;
    }

    @Override
    public Student updateProfile(Student s) {
        students.put(s.getStudentId(), s);
        return s;
    }

    @Override
    public List<JobPosting> searchJobs(String keyword, String major) {
        List<JobPosting> result = new ArrayList<>();
        for (JobPosting j : jobs.values()) {
            boolean match = true;
            if (keyword != null && !keyword.isBlank()) {
                match &= j.getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || j.getDescription().toLowerCase().contains(keyword.toLowerCase());
            }
            if (major != null && !major.isBlank()) {
                match &= j.getDescription().toLowerCase().contains(major.toLowerCase());
            }
            if (match) result.add(j);
        }
        return result;
    }

    @Override
    public boolean applyToJob(int studentId, int jobId) {
        Student s = students.get(studentId);
        JobPosting j = jobs.get(jobId);
        if (s == null || j == null) return false;

        // simple duplicate check
        for (Application a : applications.values()) {
            if (a.getStudent().getStudentId() == studentId && a.getJob().getJobId() == jobId) {
                return false;
            }
        }
        Application app = new Application(appSeq++, s, j);
        applications.put(app.getAppId(), app);
        j.addApplication(app);
        return true;
    }
}