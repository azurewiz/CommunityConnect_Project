package com.communityconnect.api.repository;

import com.communityconnect.api.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    // Spring Data JPA provides all standard CRUD methods automatically!
    // You can add custom queries here if needed, e.g., findByLocation(String location);
}