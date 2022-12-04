package com.kodlamaio.invertoryService.kafka;

import com.kodlamaio.common.events.RentalCreatedEvent;
import com.kodlamaio.common.events.RentalUpdateEvent;
import com.kodlamaio.invertoryService.business.abstracts.CarService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalConsumer {
    private CarService carService;
    //private PaymentService paymentService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RentalConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(RentalCreatedEvent event){
        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));
        carService.updateCarStateForRental(event.getCarId(),3);

        // save the order event into the database
    }

    public void consume(RentalUpdateEvent event){//carservice
        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));
        carService.updateCarStateForRental(event.getOldCarId(), 1);
        carService.updateCarStateForRental(event.getNewCarId(), 3);


        // save the order event into the database
    }

}