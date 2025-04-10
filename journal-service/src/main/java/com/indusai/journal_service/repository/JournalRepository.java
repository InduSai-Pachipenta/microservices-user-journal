package com.indusai.journal_service.repository;

import com.indusai.journal_service.model.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository  extends JpaRepository<JournalEntity,Long> {
}
