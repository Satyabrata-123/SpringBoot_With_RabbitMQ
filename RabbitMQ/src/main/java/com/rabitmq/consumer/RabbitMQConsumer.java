package com.rabitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabitmq.entity.OrderDTO;
import com.rabitmq.config.RabbitMQConfig;

@Component
public class RabbitMQConsumer {

    // Consumer disabled - DevTools test change
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(OrderDTO orderDTO) {
        System.out.println("=== RabbitMQ Consumer ===");
        System.out.println("Received message: " + orderDTO);
        System.out.println("Order ID: " + orderDTO.getOrder().getId());
        System.out.println("Order Status: " + orderDTO.getOrderStatus());
        System.out.println("Message: " + orderDTO.getMessage());
        System.out.println("========================");
    }
}