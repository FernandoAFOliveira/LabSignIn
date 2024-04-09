package com.advancedjava.LabSignIn;

import com.advancedjava.LabSignIn.model.Course;
import com.advancedjava.LabSignIn.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader; // java.io package FileReader
import java.io.IOException;

@Component
public class CourseDataLoader implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if the database is empty (optional, but recommended)
        if (courseRepository.count() == 0) {
            try (BufferedReader br = new BufferedReader(new FileReader("courses.csv"))) {
                String line;
                br.readLine(); // Skip header line
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Course course = new Course();
                    course.setCourseNumber(values[0].trim());
                    course.setCourseName(values[1].trim());
                    courseRepository.save(course);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
