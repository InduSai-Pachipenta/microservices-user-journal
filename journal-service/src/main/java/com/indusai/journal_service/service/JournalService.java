package com.indusai.journal_service.service;

import com.indusai.journal_service.model.JournalEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface JournalService {
    JournalEntity createJournal(JournalEntity journal);
    List<JournalEntity> getAllJournals();
    Optional<JournalEntity> getJournalById(Long id);
    void deleteJournal(Long id);
}
