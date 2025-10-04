package com.jpmc.midascore;
import com.jpmc.midascore.Transaction;
// FIX: Ensure this import points to the correct subdirectory

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
// ... rest of class ...
@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "${general.kafka-topic}",
            // Group ID is now supplied by spring.kafka.consumer.group-id property
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void listen(Transaction transaction) {

        // BREAKPOINT HERE: This is where you pause the debugger!
        System.out.println("Received Transaction: " + transaction.getAmount());
    }
}