//File: src\main\java\com\advancedjava\LabSignIn\service\VisitService.java

package com.advancedjava.LabSignIn.service;

import com.advancedjava.LabSignIn.model.Visit;
import com.advancedjava.LabSignIn.repository.VisitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    private static final Logger log = LoggerFactory.getLogger(VisitService.class);

    public List<Visit> getAllVisits() {
        log.debug("Retrieving all visits.");
        List<Visit> visits = visitRepository.findAll();
        log.info("Retrieved {} visits", visits.size());
        return visits;
    }

    @Transactional
    public void saveVisit(Visit visit) {
        log.debug("Saving visit: {}", visit);
        try {
            visitRepository.save(visit);
            log.info("Visit saved successfully: {}", visit);
        } catch (Exception e) {
            log.error("Error saving visit: ", e);
        }
    }
}
