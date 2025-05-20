package com.example.KAFKA_TEST.service;

import com.example.KAFKA_TEST.config.KafkaConfig;
import com.example.KAFKA_TEST.dto.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = KafkaConfig.BUILD_ORDER_TOPIC, groupId = KafkaConfig.GROUP_1)
    public void consume(String message) {
        LOGGER.info("Consumed message: {} ", message);
    }


    @KafkaListener(topics = KafkaConfig.NOTICE_TOPIC, groupId = KafkaConfig.GROUP_2,
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(UserVo user) throws InterruptedException {
        LOGGER.info("Consumed JSON Message: {} ", user);
    }
}
