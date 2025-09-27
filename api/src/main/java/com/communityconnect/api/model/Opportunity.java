package com.communityconnect.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "opportunities")
@Data // Lombok annotation to auto-generate getters, setters, etc.
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String organizationName;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    private int volunteersNeeded;
}
