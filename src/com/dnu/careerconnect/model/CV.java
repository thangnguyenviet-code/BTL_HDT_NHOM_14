package com.dnu.careerconnect.model;

import java.util.ArrayList;
import java.util.List;

public class CV {
    private int cvId;
    private String education;
    private String experience;
    private List<String> skills = new ArrayList<>();
    private String achievements;

    public CV() {}

    public CV(int cvId, String education, String experience) {
        this.cvId = cvId;
        this.education = education;
        this.experience = experience;
    }

    public int getCvId() { return cvId; }
    public void setCvId(int cvId) { this.cvId = cvId; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public List<String> getSkills() { return skills; }
    public void addSkill(String skill) { if (!skills.contains(skill)) skills.add(skill); }
    public void removeSkill(String skill) { skills.remove(skill); }

    public String getAchievements() { return achievements; }
    public void setAchievements(String achievements) { this.achievements = achievements; }

    @Override
    public String toString() {
        return "CV{" + "cvId=" + cvId + ", education='" + education + '\'' + '}';
    }
}
