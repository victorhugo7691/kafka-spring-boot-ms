package com.dev.ms_kafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ms_kafka.kafka.JsonKafkaProducer;
import com.dev.ms_kafka.payload.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/kafka/json")
public class JsonKafkaController {

    private JsonKafkaProducer jsonProducer;

    public JsonKafkaController(JsonKafkaProducer jsonProducer){
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendUser(@RequestBody User user) {
       this.jsonProducer.sendMessage(user);
       return ResponseEntity.ok("Json enviado!");
    }
    
    
}
