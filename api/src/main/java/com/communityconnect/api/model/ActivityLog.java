package com.communityconnect.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;

@Document(collection = "activityLogs") // Specifies the collection name in MongoDB
@Data
public class ActivityLog {

    @Id
    private String id; // In MongoDB, the ID is typically a String

    private String description;
    private LocalDateTime timestamp;

    public ActivityLog(String description) {
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
}
