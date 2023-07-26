package com.base.orderservice.controller;

import com.base.domains.domains.OrderStatus;
import com.base.domains.dto.Order;
import com.base.domains.dto.OrderEvent;
import com.base.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus(OrderStatus.PENDING.getStatus());
        orderEvent.setMessage(OrderStatus.PENDING.getMessage());
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "Success";
    }
}
