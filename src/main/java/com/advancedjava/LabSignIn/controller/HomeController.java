// File: src/main/java/com/advancedjava/LabSignIn/controller/HomeController.java

package com.advancedjava.LabSignIn.controller;

import com.advancedjava.LabSignIn.model.Student;
import com.advancedjava.LabSignIn.model.Course;
import com.advancedjava.LabSignIn.model.Visit;
import com.advancedjava.LabSignIn.service.StudentService;
import com.advancedjava.LabSignIn.service.CourseService;
import com.advancedjava.LabSignIn.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private VisitService visitService;

    @GetMapping("/")
    public String home(Model model) {
        // Fetch the list of courses to display in the dropdown menu
        List<Course> courses = courseService.getAllCourses(); // Assuming getAllCourses() is a method in CourseService
                                                              // that fetches all courses
        model.addAttribute("courses", courses);
        model.addAttribute("student", new Student());
        return "home"; // Uses the home.html Thymeleaf template
    }

    @PostMapping("/sign-in")
    public String submitSignInForm(@ModelAttribute Student student, @RequestParam("course") Long courseId, Model model,
            RedirectAttributes redirectAttributes) {
        studentService.saveStudent(student);

        Optional<Course> course = courseService.getCourseById(courseId);
        if (course.isPresent()) {
            Visit visit = new Visit();
            visit.setStudent(student);
            visit.setCourse(course.get());
            visit.setVisitDate(LocalDate.now());
            visit.setVisitTime(LocalTime.now());
            visitService.saveVisit(visit);
            redirectAttributes.addFlashAttribute("message", "You have successfully signed in to the Lab");
            return "redirect:/"; // Redirect back to the home page
        } else {
            model.addAttribute("error", "Invalid course selected.");
            return "home";
        }
    }
}
