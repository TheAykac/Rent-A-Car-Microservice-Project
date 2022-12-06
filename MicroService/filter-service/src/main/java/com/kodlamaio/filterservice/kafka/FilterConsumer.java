package com.kodlamaio.filterservice.kafka;

import com.kodlamaio.common.events.FilterCreatedEvent;
import com.kodlamaio.filterservice.business.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilterConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterConsumer.class);
    private FilterService filterService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(FilterCreatedEvent event) {
        LOGGER.info(String.format("Order event received in note service => %s", event.toString()));
        filterService.filter(event);

    }
}
