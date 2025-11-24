package com.dnu.careerconnect.model;

public class Student {
    private int id;
    private String username; 
    private String password;
    private String name;
    private CV cv;

    public Student(int id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public CV getCv() { return cv; }
    public void setCv(CV cv) { this.cv = cv; }
}