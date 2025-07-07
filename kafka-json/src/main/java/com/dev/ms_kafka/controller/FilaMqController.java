package com.dev.ms_kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ms_kafka.ibmmq.IbmMqConsumer;

@RestController
@RequestMapping("/ibmmq")
public class FilaMqController {

    private IbmMqConsumer ibmMqConsumer;

    public FilaMqController(IbmMqConsumer ibmMqConsumer) {
        this.ibmMqConsumer = ibmMqConsumer;
    }

    @GetMapping()
    public ResponseEntity<String> consultarFilaMq() {
        return ResponseEntity.ok(this.ibmMqConsumer.consumerIbmMq());
    }

}
