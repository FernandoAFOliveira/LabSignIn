// File: src/main/java/com/advancedjava/LabSignIn/repository/CourseRepository.java

package com.advancedjava.LabSignIn.repository;

import com.advancedjava.LabSignIn.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom query methods can be added here
}
