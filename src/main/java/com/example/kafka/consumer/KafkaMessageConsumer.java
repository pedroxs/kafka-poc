package com.example.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * Listens to messages on topic "myTopic".
 */
@Slf4j
@Component
public class KafkaMessageConsumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "myTopic", partitions = {"0"}))
    public void listenToPart0(ConsumerRecord cr) throws Exception {
        log.info(cr.toString());
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "myTopic", partitions = {"1"}))
    public void listenToPart1(ConsumerRecord cr) throws Exception {
        log.info(cr.toString());
    }

}
