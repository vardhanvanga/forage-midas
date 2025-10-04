package com.jpmc.midascore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;

// CRITICAL: Marks this class as a database entity
@Entity
public class Transaction {

    // CRITICAL: Primary Key setup
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fields used throughout the simulation
    private String userId;
    private BigDecimal amount;

    // --- CONSTRUCTORS ---

    // 1. MANDATORY: The public no-argument constructor required by JPA/Hibernate.
    public Transaction() {
    }

    // 2. CRITICAL: The constructor required by the KafkaProducer.java test file (long, long, float).
    public Transaction(long id, long timestamp, float initialAmount) {
        this.id = id;
        // The original test often assumes userId is related to the ID or is a fixed value.
        // We ensure the field is set using the incoming data.
        this.userId = "USER-" + id;
        this.amount = BigDecimal.valueOf(initialAmount);
    }

    // --- GETTERS AND SETTERS (REQUIRED BY JPA/HIBERNATE) ---

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // NOTE: If your original file had other fields (like 'timestamp' or 'type'),
    // you must re-add them here with corresponding getters/setters.
}