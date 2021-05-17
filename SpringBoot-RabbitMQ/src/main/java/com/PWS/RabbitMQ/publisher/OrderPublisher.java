package com.PWS.RabbitMQ.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PWS.RabbitMQ.config.STATIC;
import com.PWS.RabbitMQ.entity.Order;
import com.PWS.RabbitMQ.entity.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());// dynamic id creation
        OrderStatus orderStatus = new OrderStatus(order, "PROGRESS", "order placed succesfully in " + restaurantName);
        template.convertAndSend(STATIC.EXCHANGE, STATIC.ROUTING_KEY, orderStatus);
        System.out.println(STATIC.EXCHANGE +","+STATIC.ROUTING_KEY+","+orderStatus);
        return "Success !! Order has been placed";
    }
}