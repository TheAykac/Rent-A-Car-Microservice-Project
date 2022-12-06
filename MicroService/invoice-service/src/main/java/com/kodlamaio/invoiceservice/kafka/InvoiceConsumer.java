package com.kodlamaio.invoiceservice.kafka;

import com.kodlamaio.common.events.InvoiceCreatedEvent;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InvoiceConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceConsumer.class);
    private InvoiceService invoiceService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(InvoiceCreatedEvent event) {
        LOGGER.info(String.format("Order event received in note service => %s", event.toString()));
        invoiceService.createInvoice(event.getStartDate(), event.getTotalRentalDay(), event.getPriceOfDays(), event.getRentalCarTotalPrice(), event.getRentalCarId());

    }


}
