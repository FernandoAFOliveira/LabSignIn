// File: src/main/java/com/advancedjava/LabSignIn/controller/CourseController.java

package com.advancedjava.LabSignIn.controller;

import com.advancedjava.LabSignIn.model.Course;
import com.advancedjava.LabSignIn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses/list"; // Thymeleaf template for listing courses
    }

    // Additional methods for adding, updating, viewing a specific course can be
    // added here
}
