package com.dnu.careerconnect.model;

public class User {
    private String username;
    private String password;
    private String role;
    private CV cv; 

    public User(String username, String password, String role) {
        this.username = username; this.password = password; this.role = role;
    }

    public CV getCv() { return cv; }
    public void setCv(CV cv) { this.cv = cv; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
