package com.kodlamaio.paymentservice.kafka;

import com.kodlamaio.common.events.PaymentCreatedEvent;
import com.kodlamaio.common.events.RentalCreatedEvent;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, PaymentCreatedEvent> kafkaTemplate;

    public PaymentProducer(NewTopic topic, KafkaTemplate<String, PaymentCreatedEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(PaymentCreatedEvent paymentCreatedEvent) {
        LOGGER.info(String.format("Rental created event => %s", paymentCreatedEvent.toString()));

        Message<PaymentCreatedEvent> message = MessageBuilder
                .withPayload(paymentCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name()).build();

        kafkaTemplate.send(message);
    }

}