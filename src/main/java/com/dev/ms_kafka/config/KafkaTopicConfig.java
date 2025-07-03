package com.dev.ms_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaGuideTopic(){
        return TopicBuilder.name("javaguides")
        .build();
        //.partitions(10).build(); é possível escolher as partições
    }
}
