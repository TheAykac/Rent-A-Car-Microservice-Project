package com.kodlamaio.rentalService.kafka;

import com.kodlamaio.common.events.InvoiceCreatedEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceProducer.class);

    private final NewTopic topic;

    private final KafkaTemplate<String, InvoiceCreatedEvent> kafkaTemplate;

    public InvoiceProducer(NewTopic topic, KafkaTemplate<String, InvoiceCreatedEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(InvoiceCreatedEvent InvoiceCreatedEvent) {
        LOGGER.info(String.format("Invoice created event => %s", InvoiceCreatedEvent.toString()));

        Message<InvoiceCreatedEvent> message = MessageBuilder
                .withPayload(InvoiceCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name()).build();

        kafkaTemplate.send(message);
    }
}
