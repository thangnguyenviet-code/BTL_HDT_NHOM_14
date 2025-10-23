package com.dnu.careerconnect.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private int studentId;
    private String fullName;
    private String major;
    private List<String> skills = new ArrayList<>();
    private CV cv;

    public Student() { this.setRole("STUDENT"); }

    public Student(int studentId, String fullName, String major) {
        super();
        this.setRole("STUDENT");
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public List<String> getSkills() { return skills; }
    public void addSkill(String skill) { if (!skills.contains(skill)) skills.add(skill); }
    public void removeSkill(String skill) { skills.remove(skill); }

    public CV getCv() { return cv; }
    public void setCv(CV cv) { this.cv = cv; }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", fullName='" + fullName + '\'' +
                ", major='" + major + '\'' + ", skills=" + skills + '}';
    }
}
