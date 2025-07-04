package com.dev.ms_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dev.ms_kafka.payload.User;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${topic-name-kafka}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user){
        LOGGER.info("Json recebido " + user.toString());
    }
    
}
