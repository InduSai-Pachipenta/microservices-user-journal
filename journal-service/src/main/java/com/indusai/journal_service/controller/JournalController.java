package com.indusai.journal_service.controller;

import com.indusai.journal_service.model.JournalEntity;
import com.indusai.journal_service.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journals")
public class JournalController {

    @Autowired
    private JournalService journalService;

    // Create journal (e.g., after receiving from Kafka)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('JOURNALER')")
    public ResponseEntity<JournalEntity> createJournal(@RequestBody JournalEntity journal) {
        JournalEntity createdJournal = journalService.createJournal(journal);
        return ResponseEntity.ok(createdJournal);
    }

    // Get all journals
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('VIEWER')")
    public ResponseEntity<List<JournalEntity>> getAllJournals() {
        return ResponseEntity.ok(journalService.getAllJournals());
    }

    // Get journal by ID
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VIEWER')")
    public ResponseEntity<JournalEntity> getJournalById(@PathVariable Long id) {
        Optional<JournalEntity> journal = journalService.getJournalById(id);
        return journal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete journal
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteJournal(@PathVariable Long id) {
        journalService.deleteJournal(id);
        return ResponseEntity.noContent().build();
    }
}
