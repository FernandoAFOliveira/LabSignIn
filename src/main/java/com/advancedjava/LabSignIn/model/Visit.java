//File: src\main\java\com\advancedjava\LabSignIn\model\Visit.java

package com.advancedjava.LabSignIn.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate visitDate;
    private LocalTime visitTime;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return LocalDate return the visitDate
     */
    public LocalDate getVisitDate() {
        return visitDate;
    }

    /**
     * @param visitDate the visitDate to set
     */
    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * @return LocalTime return the visitTime
     */
    public LocalTime getVisitTime() {
        return visitTime;
    }

    /**
     * @param visitTime the visitTime to set
     */
    public void setVisitTime(LocalTime visitTime) {
        this.visitTime = visitTime;
    }

    /**
     * @return Student return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return Course return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

}
