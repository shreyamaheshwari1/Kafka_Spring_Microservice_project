package com.kafka.order_service.controller;

import com.kafka.base_domains.Order.OrderEvent;
import com.kafka.base_domains.Order.Orders;
import com.kafka.order_service.service.OrderProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

//    declaring of the producer service
    private OrderProducerService orderproducerservice;
//injecting the service here by spring
    public OrderController(OrderProducerService orderproducerservice) {
        this.orderproducerservice = orderproducerservice;
    }

//    @RequestBody converts json object into java object


    @PostMapping("/orders")
    public String placeOrder(@RequestBody Orders order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderevent= new OrderEvent();
        orderevent.setStatus("PENDING");
        orderevent.setMessage("order status is in pending state");
        orderevent.setOrder(order);

        orderproducerservice.sendMessage(orderevent);
        return "Order Placed Successfully";

    }
}
