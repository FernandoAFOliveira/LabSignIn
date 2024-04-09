// File: src/main/java/com/advancedjava/LabSignIn/service/StudentService.java

package com.advancedjava.LabSignIn.service;

import com.advancedjava.LabSignIn.model.Student;
import com.advancedjava.LabSignIn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Additional methods like update, delete can be added here
}
