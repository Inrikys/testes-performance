package com.testesperformance.exemplo.config;

import com.testesperformance.exemplo.adapters.out.producer.message.ZupperRegistradoMessage;
import com.testesperformance.exemplo.config.mock.NotMockExternalServicesCondition;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaProducerConfig {
    @Bean
    @Conditional(NotMockExternalServicesCondition.class)
    public ProducerFactory<String, ZupperRegistradoMessage> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(GROUP_ID_CONFIG, "cafe-fullstack");
        configProps.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    @Conditional(NotMockExternalServicesCondition.class)
    public KafkaTemplate<String, ZupperRegistradoMessage> kafkaTemplate() {
        return new KafkaTemplate<String, ZupperRegistradoMessage>(producerFactory());
    }

}