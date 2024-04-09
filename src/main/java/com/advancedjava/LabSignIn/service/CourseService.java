// File: src/main/java/com/advancedjava/LabSignIn/service/CourseService.java

package com.advancedjava.LabSignIn.service;

import com.advancedjava.LabSignIn.model.Course;
import com.advancedjava.LabSignIn.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Additional methods for update, delete, etc., can be added
}
