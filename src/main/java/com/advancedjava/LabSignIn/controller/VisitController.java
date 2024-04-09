package com.advancedjava.LabSignIn.controller;

import com.advancedjava.LabSignIn.model.Visit;
import com.advancedjava.LabSignIn.service.CourseService;
import com.advancedjava.LabSignIn.service.StudentService;
import com.advancedjava.LabSignIn.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class VisitController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private VisitService visitService;

    @GetMapping("/visits/sign-in")
    public String showSignInForm(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("visit", new Visit());
        return "visits/sign-in";
    }

    @PostMapping("/visits/sign-in")
    public String submitSignInForm(Visit visit) {
        visit.setVisitDate(LocalDate.now());
        visit.setVisitTime(LocalTime.now());
        visitService.saveVisit(visit);
        return "redirect:/"; // Or wherever you want to redirect after signing in
    }

    // Additional methods as needed
}
