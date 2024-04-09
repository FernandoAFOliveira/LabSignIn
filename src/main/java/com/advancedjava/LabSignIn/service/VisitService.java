package com.advancedjava.LabSignIn.service;

import com.advancedjava.LabSignIn.model.Visit;
import com.advancedjava.LabSignIn.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public void saveVisit(Visit visit) {
        visitRepository.save(visit);
    }

    // Additional methods as needed
}
