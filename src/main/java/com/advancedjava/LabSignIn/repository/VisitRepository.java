//File: src\main\java\com\advancedjava\LabSignIn\repository\VisitRepository.java

package com.advancedjava.LabSignIn.repository;

import com.advancedjava.LabSignIn.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
