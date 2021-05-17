package com.PWS.RabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.PWS.RabbitMQ.config.STATIC;
import com.PWS.RabbitMQ.entity.OrderStatus;

@Component
public class User {

    @RabbitListener(queues = STATIC.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue and consumed : " + orderStatus);
    }
}