package com.indusai.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventDTO {
    private Long userId;
    private String username;
    private String email;
    private String role;
    private String action;
    private String eventType; // e.g., CREATED, UPDATED, DELETED
    private String timestamp;
}
