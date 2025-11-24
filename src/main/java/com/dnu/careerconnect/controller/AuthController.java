package com.dnu.careerconnect.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.dnu.careerconnect.model.CV;
import com.dnu.careerconnect.model.Student;
import com.dnu.careerconnect.model.User;
import com.dnu.careerconnect.service.StudentService;

@Controller
@SessionAttributes("user")
public class AuthController {
    private final List<User> demoUsers = Arrays.asList(
        new User("sv1", "123", "student"),
        new User("sv2", "123", "student"),
        new User("ntd1", "123", "employer"),
        new User("admin", "admin", "admin")
    );

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("demoUsers", demoUsers);
        model.addAttribute("error", null);
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        Optional<User> u = demoUsers.stream()
            .filter(x -> x.getUsername().equals(username) && x.getPassword().equals(password))
            .findFirst();
        if (u.isPresent()) {
            model.addAttribute("user", u.get());
            if ("student".equals(u.get().getRole())) {
                Student student = studentService.getStudentByUsername(username);
                if (student == null) {
                    student = new Student(studentService.generateId(), username, password, username);
                    studentService.addStudent(student);
                }
            }
            switch (u.get().getRole()) {
                case "student": return "redirect:/student";
                case "employer": return "redirect:/employer";
                case "admin": return "redirect:/admin";
            }
        }
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(WebRequest request) {
        request.removeAttribute("user", WebRequest.SCOPE_SESSION);
        return "redirect:/login";
    }

    @GetMapping("/cv")
    public String showCV(Model model, @ModelAttribute("user") User user) {
        if (!"student".equals(user.getRole())) return "redirect:/login";
        model.addAttribute("cv", user.getCv());
        return "cv";
    }

    @PostMapping("/cv")
    public String updateCV(
        @RequestParam String education,
        @RequestParam String skills,
        @RequestParam String email,
        @RequestParam String phone,
        @RequestParam(value = "avatarFile", required = false) MultipartFile avatarFile,
        @ModelAttribute("user") User user) {
        if (!"student".equals(user.getRole())) return "redirect:/login";
        String imageUrl = user.getCv() != null ? user.getCv().getImageUrl() : null;
        if (avatarFile != null && !avatarFile.isEmpty()) {
            try {
                String ext = avatarFile.getOriginalFilename().substring(avatarFile.getOriginalFilename().lastIndexOf('.'));
                String filename = user.getUsername() + "_" + System.currentTimeMillis() + ext;
                Path targetPath = Paths.get("src/main/resources/static/images/" + filename);
                avatarFile.transferTo(targetPath);
                imageUrl = "/images/" + filename;
            } catch(Exception e) {
                // Log error nếu muốn
            }
        }
        CV cv = new CV(education, skills, email, phone, imageUrl);
        user.setCv(cv);
        Student student = studentService.getStudentByUsername(user.getUsername());
        if (student != null) {
            student.setCv(cv);
        }
        return "redirect:/student";
    }
}
