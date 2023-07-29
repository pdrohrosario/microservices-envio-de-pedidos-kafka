package com.base.orderservice.controller;

import com.base.domains.domains.RequestStatus;
import com.base.domains.dto.RequestDTO;
import com.base.domains.dto.RequestEvent;
import com.base.orderservice.kafka.RequestProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class RequestController {

    private RequestProducer requestProducer;

    public RequestController(RequestProducer requestProducer) {
        this.requestProducer = requestProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody RequestDTO order){

        order.setId(UUID.randomUUID().toString());

        RequestEvent orderEvent = new RequestEvent();
        orderEvent.setStatus(RequestStatus.PENDING.getStatus());
        orderEvent.setMessage(RequestStatus.PENDING.getMessage());
        orderEvent.setOrder(order);

        requestProducer.sendMessage(orderEvent);
        return "Success";
    }
}
