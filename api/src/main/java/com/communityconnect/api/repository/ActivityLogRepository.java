package com.communityconnect.api.repository;

import com.communityconnect.api.model.ActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends MongoRepository<ActivityLog, String> {
    // MongoRepository provides standard methods like save(), findAll(), etc.
}
