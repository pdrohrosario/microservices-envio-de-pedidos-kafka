package com.base.stockservice.kafka;

import com.base.domains.dto.RequestDTO;
import com.base.domains.dto.RequestEvent;
import com.base.stockservice.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private StockService stockService;

    public OrderConsumer(StockService stockService) {
        this.stockService = stockService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(RequestEvent event){
        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));
        RequestDTO dto = event.getOrder();
        this.stockService.create(dto);
    }
}
