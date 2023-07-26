package com.base.orderservice.kafka;

import com.base.domains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private NewTopic topic;

    private KafkaTemplate<String, OrderEvent> template;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> template) {
        this.topic = topic;
        this.template = template;
    }

    public void sendMessage(OrderEvent event){
        LOGGER.info(String.format("Order event => %s", event.toString()));

        //create message
        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        template.send(message);
    }
}