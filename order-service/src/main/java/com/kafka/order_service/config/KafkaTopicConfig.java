package com.kafka.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

//    spring bean for kafka topic
//    When your application starts,
//    Spring checks for any beans of type NewTopic. Spring’s Kafka integration then uses this bean to create the Kafka topic on the broker if it doesn’t already exist
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(topicName)
                .build();
    }

}
