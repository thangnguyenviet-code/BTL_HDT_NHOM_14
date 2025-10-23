package com.dnu.careerconnect.service;

import com.dnu.careerconnect.model.Student;
import com.dnu.careerconnect.model.JobPosting;

import java.util.List;

public interface StudentService {
    Student createProfile(Student s);
    Student updateProfile(Student s);
    List<JobPosting> searchJobs(String keyword, String major);
    boolean applyToJob(int studentId, int jobId);
}