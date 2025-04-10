package com.indusai.journal_service.service;

import com.indusai.journal_service.model.JournalEntity;
import com.indusai.journal_service.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private JournalRepository journalRepository;

    @KafkaListener(topics = "user-events", groupId = "journal-group")
    public void consumeUserEvent(String eventMessage) {
        System.out.println("Received event from Kafka: " + eventMessage);

        // For demo, we're storing the raw message as content
        JournalEntity journal = new JournalEntity();
        journal.setEventMessage(eventMessage); // Make sure you have this field in JournalEntity

        journalRepository.save(journal);
    }
}
