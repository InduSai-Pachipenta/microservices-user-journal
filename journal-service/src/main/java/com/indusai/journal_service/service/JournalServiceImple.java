package com.indusai.journal_service.service;

import com.indusai.journal_service.model.JournalEntity;
import com.indusai.journal_service.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImple implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public JournalEntity createJournal(JournalEntity journal) {
        return journalRepository.save(journal);
    }

    @Override
    public List<JournalEntity> getAllJournals() {
        return journalRepository.findAll();
    }

    @Override
    public Optional<JournalEntity> getJournalById(Long id) {
        return journalRepository.findById(id);
    }

    @Override
    public void deleteJournal(Long id) {
        journalRepository.deleteById(id);
    }
}
