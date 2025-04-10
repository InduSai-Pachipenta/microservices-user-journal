package com.indusai.user_service.service;

import com.indusai.user_service.dto.UserEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "user-events";

    @Autowired
    private KafkaTemplate<String, UserEventDTO> kafkaTemplate;

    public void sendUserEvent(UserEventDTO eventDTO) {
        kafkaTemplate.send(TOPIC, eventDTO);
    }
}
