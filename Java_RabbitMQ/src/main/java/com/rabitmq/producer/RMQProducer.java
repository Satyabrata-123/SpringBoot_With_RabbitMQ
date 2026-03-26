package com.rabitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rabitmq.entity.Order;
import com.rabitmq.entity.OrderDTO;
import com.rabitmq.config.RabbitMQConfig;

@RestController
@RequestMapping("/api")
public class RMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @PostMapping("/order")
    public OrderDTO placeOrder(@RequestBody Order order) {
        OrderDTO orderDTO = new OrderDTO(order, "Order Placed", "Your order has been placed successfully");
        
        System.out.println("=== RabbitMQ Producer ===");
        System.out.println("Sending message to exchange: " + RabbitMQConfig.EXCHANGE);
        System.out.println("Routing key: " + RabbitMQConfig.ROUTING_KEY);
        System.out.println("Message: " + orderDTO);
        
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderDTO);
        
        System.out.println("Message sent successfully!");
        System.out.println("========================");
        
        return orderDTO;
    }
}
