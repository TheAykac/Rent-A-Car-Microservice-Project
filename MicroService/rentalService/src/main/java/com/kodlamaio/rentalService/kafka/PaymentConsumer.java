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
<<<<<<< HEAD
        //rentalService.calculateTotalPrice(event.getDailyPrice(), event.getRentedForDays());
=======
        rentalService.
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe


        // save the order event into the database
    }
}
<<<<<<< HEAD
/*
* RENTAL
* -DailyPrice, RentedForDays
*
*
* */
=======
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
