package com.kodlamaio.invertoryService.kafka;

import com.kodlamaio.common.events.FilterCreatedEvent;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilterProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, FilterCreatedEvent> kafkaTemplate;


    public void sendMessage(FilterCreatedEvent filterCreatedEvent) {
        LOGGER.info(String.format("Filter created event => %s", filterCreatedEvent.toString()));

        Message<FilterCreatedEvent> message = MessageBuilder
                .withPayload(filterCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name()).build();

        kafkaTemplate.send(message);
    }
}
