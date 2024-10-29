package com.kafka.stock_service.Service;

import com.kafka.base_domains.Order.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(StockConsumerService.class);
    @KafkaListener(
            topics="${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderevent){
    LOGGER.info(String.format("order event received in stock service => %s", orderevent.toString()));
//    save the event data into the database

    }
}
