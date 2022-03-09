package com.haydikodlayalim.kafka;

import com.haydikodlayalim.kafka.dto.KMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {
    @KafkaListener(
            topics = "${haydikodlayalim.kafka.topic}",
            groupId = "${haydikodlayalim.kafka.group.id}"
    )
    public void listen(@Payload KMessage kmessage) {
        log.info("Message received.. MessageId : {} Message: {} Date: {}",
                kmessage.getId(),
                kmessage.getMessage(),
                kmessage.getMessageDate());
    }

}
