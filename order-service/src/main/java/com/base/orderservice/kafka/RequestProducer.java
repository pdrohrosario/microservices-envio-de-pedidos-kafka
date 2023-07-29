package com.base.orderservice.kafka;

import com.base.domains.dto.RequestEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RequestProducer {

    private NewTopic topic;

    private KafkaTemplate<String, RequestEvent> template;

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestProducer.class);
    public RequestProducer(NewTopic topic, KafkaTemplate<String, RequestEvent> template) {
        this.topic = topic;
        this.template = template;
    }

    public void sendMessage(RequestEvent event){
        LOGGER.info(String.format("Order event => %s", event.toString()));

        //create message
        Message<RequestEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        template.send(message);
    }
}
