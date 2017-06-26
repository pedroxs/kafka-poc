package com.example.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

/**
 * Sends a message to "myTopic" every second
 */
@Slf4j
@Component
public class KafkaMessageProducer {

    private final Random random = new Random();

    @Autowired
    private KafkaTemplate<String, String> template;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        int partition = random.nextInt(2);
        log.info("Sending message to partition: {}", partition);
        template.send("myTopic", partition, ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
    }
}
