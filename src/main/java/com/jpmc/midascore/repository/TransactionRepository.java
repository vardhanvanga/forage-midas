package com.jpmc.midascore.repository;

import com.jpmc.midascore.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // NOTE: This custom query method is MANDATORY for Task 5 logic to be correct.
    // It sums the 'amount' field for a given userId.
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.userId = :userId")
    BigDecimal findTotalAmountByUserId(String userId);

    // Assuming the primary key of Transaction is a Long.
}