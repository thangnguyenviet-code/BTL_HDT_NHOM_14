package com.dnu.careerconnect.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dnu.careerconnect.model.CV;
import com.dnu.careerconnect.model.Student;

@Service
public class StudentService {
    private Map<Integer, Student> students = new HashMap<>();
    private Map<String, Student> studentsByUsername = new HashMap<>();
    private int seq = 1;

    // Khởi tạo sẵn 2 tài khoản sinh viên demo
    public StudentService() {
        addDemoStudents();
    }
    private void addDemoStudents() {
        Student sv1 = new Student(seq++, "sv1", "123", "Nguyen Van Nam");
        Student sv2 = new Student(seq++, "sv2", "123", "Long");
        students.put(sv1.getId(), sv1); studentsByUsername.put(sv1.getUsername(), sv1);
        students.put(sv2.getId(), sv2); studentsByUsername.put(sv2.getUsername(), sv2);
    }
    public int generateId() {
        return seq++;
    }
    public void addStudent(Student s) {
        students.put(s.getId(), s);
        studentsByUsername.put(s.getUsername(), s);
    }

    public Student getStudent(int id)      { return students.get(id); }
    public Student getStudentByUsername(String username) { return studentsByUsername.get(username); }
    public void saveCV(int id, String education, String skills, String email, String phone, String imageUrl) {
        Student s = students.get(id);
        if (s != null) s.setCv(new CV(education, skills, email, phone, imageUrl));
    }
}