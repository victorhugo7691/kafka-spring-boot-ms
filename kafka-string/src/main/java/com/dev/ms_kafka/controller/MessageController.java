package com.dev.ms_kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ms_kafka.kafka.KafkaProducer;

@RestController
@RequestMapping("/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }
    
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        this.kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Mensagem enviada");
    }
    
}
