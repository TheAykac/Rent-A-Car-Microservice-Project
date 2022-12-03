package com.kodlamaio.rentalService.kafka;

import com.kodlamaio.common.events.PaymentCreatedEvent;
import com.kodlamaio.common.events.RentalCreatedEvent;
import com.kodlamaio.rentalService.business.abstracts.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    private RentalService rentalService;

    //private PaymentService paymentService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(PaymentCreatedEvent event){
        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));
        rentalService.


        // save the order event into the database
    }
}
