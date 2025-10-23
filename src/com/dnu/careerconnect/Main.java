package com.dnu.careerconnect;

import com.dnu.careerconnect.model.*;
import com.dnu.careerconnect.serviceimpl.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Shared in-memory stores
        Map<Integer, JobPosting> jobStore = new HashMap<>();
        Map<Integer, Application> appStore = new HashMap<>();

        // Services
        InMemoryUserService userService = new InMemoryUserService();
        InMemoryEmployerService employerService = new InMemoryEmployerService(jobStore, appStore);
        InMemoryStudentService studentService = new InMemoryStudentService(jobStore, appStore);

        // Create employer and post job
        Employer emp = new Employer(1, "DNU Tech", "Information Technology");
        JobPosting job = new JobPosting(0, "Junior Java Developer", "Work on backend systems");
        job.setEmployer(emp);
        job.setDeadline(LocalDate.now().plusDays(30));
        job.setRequirements("Java, OOP, SQL");
        employerService.postJob(job);

        System.out.println("Posted job: " + job);

        // Create student and profile
        Student st = new Student(1001, "Nguyen Van A", "Computer Science");
        st.addSkill("Java");
        st.addSkill("SQL");
        studentService.createProfile(st);

        // Student searches and applies
        var results = studentService.searchJobs("Java", "Computer Science");
        System.out.println("Search results: " + results);

        boolean applied = studentService.applyToJob(1001, job.getJobId());
        System.out.println("Applied? " + applied);

        // Employer views applications
        var apps = job.getApplications();
        System.out.println("Applications for job: " + apps);

        // Employer responds
        if (!apps.isEmpty()) {
            var firstApp = apps.get(0);
            employerService.respondToApplication(firstApp.getAppId(), "INTERVIEW");
            System.out.println("Application status updated: " + firstApp);
        }
    }
}