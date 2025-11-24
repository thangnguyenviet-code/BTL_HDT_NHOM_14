package com.dnu.careerconnect.model;

public class CV {
    private String education;
    private String skills;
    private String email;
    private String phone;
    private String imageUrl; // hoặc lưu tên file ảnh

    public CV() {}

    public CV(String education, String skills, String email, String phone, String imageUrl) {
        this.education = education;
        this.skills = skills;
        this.email = email;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
