// File: src/main/java/com/advancedjava/LabSignIn/controller/StudentController.java

package com.advancedjava.LabSignIn.controller;

import com.advancedjava.LabSignIn.model.Student;
import com.advancedjava.LabSignIn.model.Course;
import com.advancedjava.LabSignIn.service.StudentService;
import com.advancedjava.LabSignIn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/list"; // Thymeleaf template for listing students
    }

    @GetMapping("/sign-in")
    public String showSignInForm(Model model) {
        List<Course> courses = courseService.findAll(); // Ensure this method exists in CourseService
        model.addAttribute("courses", courses);
        model.addAttribute("student", new Student());
        return "students/sign-in";
    }

    @PostMapping("/sign-in")
    public String submitSignInForm(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Additional methods for update, delete, etc., can be added here
}
