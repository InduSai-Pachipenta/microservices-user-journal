package com.indusai.journal_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEventDTO {
    private Long userId;
    private String username;
    private String action; // e.g., CREATED, UPDATED, DELETED
    private String timestamp;
}
