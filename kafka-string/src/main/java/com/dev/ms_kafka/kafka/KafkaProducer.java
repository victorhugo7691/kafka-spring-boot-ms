package com.dev.ms_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic-name-kafka}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        try{
            this.kafkaTemplate.send(topicName, message);
            LOGGER.info("Mensagem enviada: " + message);
        }catch(RuntimeException e){
            LOGGER.error("Falha no envio da mensagem: " + message, e);
        }
    }
}
