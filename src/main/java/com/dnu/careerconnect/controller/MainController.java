package com.dnu.careerconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dnu.careerconnect.model.JobPosting;
import com.dnu.careerconnect.model.User;
import com.dnu.careerconnect.service.JobService;
import com.dnu.careerconnect.service.StudentService;

@Controller
@SessionAttributes("user")
public class MainController {
    @Autowired JobService jobService;
    @Autowired StudentService studentService;

    // Trang chủ chuyển đến đúng vai trò
    @GetMapping("/")
    public String home(Model model, @ModelAttribute("user") User user) {
        if (user == null) return "redirect:/login";
        switch (user.getRole()) {
            case "student": return "redirect:/student";
            case "employer": return "redirect:/employer";
            case "admin": return "redirect:/admin";
        }
        return "login";
    }

    // Trang sinh viên - hiển thị danh sách việc làm, thông báo ứng tuyển
    @GetMapping("/student")
    public String studentHome(Model model, @ModelAttribute("user") User user,
                             @RequestParam(value = "msg", required = false) String msg,
                             @RequestParam(value = "error", required = false) String error) {
        if (user == null || !"student".equals(user.getRole())) return "redirect:/login";
        model.addAttribute("jobs", jobService.getAllJobs());
        if (msg != null) model.addAttribute("msg", msg);
        if (error != null) model.addAttribute("error", error);
        return "student_home";
    }

    // Sinh viên ứng tuyển job
    @PostMapping("/apply/{id}")
    public String applyJob(@PathVariable int id, Model model, @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        if (user == null || !"student".equals(user.getRole())) return "redirect:/login";
        // KHÔNG lấy job, KHÔNG tạo application, chỉ hiện thông báo
        redirectAttributes.addFlashAttribute("msg", "Bạn đã ứng tuyển công việc này!");
        return "redirect:/student";
    }
    
    // Trang nhà tuyển dụng - danh sách jobs đã đăng
    @GetMapping("/employer")
    public String employerHome(Model model, @ModelAttribute("user") User user) {
        if (user == null || !"employer".equals(user.getRole())) return "redirect:/login";
        model.addAttribute("username", user.getUsername());
        model.addAttribute("jobs", jobService.getAllJobs());
        return "employer_home";
    }

    // Form tạo job mới cho nhà tuyển dụng
    @GetMapping("/addjob_form")
    public String addJobForm(Model model, @ModelAttribute("user") User user) {
        if (user == null || !"employer".equals(user.getRole())) return "redirect:/login";
        return "addjob_form";
    }

    @PostMapping("/addjob")
    public String addJob(@RequestParam String title, @RequestParam String description,
                         @RequestParam String employer, @ModelAttribute("user") User user) {
        if (user == null || !"employer".equals(user.getRole())) return "redirect:/login";
        jobService.postJob(title, description, employer);
        return "redirect:/employer";
    }

    // Xem danh sách ứng viên cho từng job
    @GetMapping("/employer/job/{id}/applications")
    public String viewApplications(@PathVariable int id, Model model, @ModelAttribute("user") User user) {
        if (user == null || !"employer".equals(user.getRole())) return "redirect:/login";
        JobPosting job = jobService.getJob(id);
        model.addAttribute("job", job);
        model.addAttribute("applications", job != null ? job.getApplications() : null);
        return "applications_view";
    }

    // Trang admin - xem danh sách job/tùy chỉnh
    @GetMapping("/admin")
    public String adminHome(Model model, @ModelAttribute("user") User user) {
        if (user == null || !"admin".equals(user.getRole())) return "redirect:/login";
        model.addAttribute("username", user.getUsername());
        model.addAttribute("jobs", jobService.getAllJobs());
        return "admin_home";
    }

    // Admin xóa job đăng tuyển
    @PostMapping("/admin/deletejob")
    public String deleteJob(@RequestParam int jobId, @ModelAttribute("user") User user) {
        if (user == null || !"admin".equals(user.getRole())) return "redirect:/login";
        jobService.deleteJob(jobId);
        return "redirect:/admin";
    }
}