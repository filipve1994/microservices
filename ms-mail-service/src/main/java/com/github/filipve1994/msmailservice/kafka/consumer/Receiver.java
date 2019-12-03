package com.github.filipve1994.msmailservice.kafka.consumer;

import com.github.filipve1994.msmailservice.dto.UserDto;
import com.github.filipve1994.msmailservice.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    public void receiver(UserDto payload){
        logger.info("received payload='{}'", payload);
        emailService.sendSimpleMessage(payload);
        countDownLatch.countDown();
    }

}
