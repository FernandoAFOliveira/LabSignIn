// File: src/main/java/com/advancedjava/LabSignIn/repository/StudentRepository.java

package com.advancedjava.LabSignIn.repository;

import com.advancedjava.LabSignIn.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // You can define custom query methods here if needed
}
