package com.dev.ms_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${topic-name-kafka}")
    private String topicName;

    @Bean
    public NewTopic javaGuideTopic(){
        return TopicBuilder.name(topicName)
        .build();
        //.partitions(10).build(); é possível escolher as partições
    }
}
