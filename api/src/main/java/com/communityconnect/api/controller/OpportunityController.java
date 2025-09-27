package com.communityconnect.api.controller;

import com.communityconnect.api.model.ActivityLog;
import com.communityconnect.api.model.Opportunity;
import com.communityconnect.api.repository.ActivityLogRepository;
import com.communityconnect.api.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opportunities")
@CrossOrigin(origins = "http://localhost:3000") // Base path for all endpoints in this controller
public class OpportunityController {

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private ActivityLogRepository activityLogRepository;

    // GET /api/opportunities -> Get all opportunities
    @GetMapping
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    // GET /api/opportunities/{id} -> Get a single opportunity by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Opportunity> getOpportunityById(@PathVariable Long id) {
        Optional<Opportunity> opportunity = opportunityRepository.findById(id);
        // If found, return 200 OK with the opportunity, otherwise return 404 Not Found
        return opportunity.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/opportunities -> Create a new opportunity
    @PostMapping
    public ResponseEntity<Opportunity> createOpportunity(@RequestBody Opportunity opportunity) {
        Opportunity savedOpportunity = opportunityRepository.save(opportunity);

        // --- LOGGING TO MONGODB ---
        // Create a new log entry
        ActivityLog log = new ActivityLog("Created new opportunity: '" + savedOpportunity.getTitle() + "'");
        // Save the log to MongoDB
        activityLogRepository.save(log);
        // -------------------------

        return new ResponseEntity<>(savedOpportunity, HttpStatus.CREATED);
    }
}