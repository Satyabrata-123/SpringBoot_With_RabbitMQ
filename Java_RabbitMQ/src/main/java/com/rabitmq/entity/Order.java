package com.rabitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    
    private Integer id;
    private String name;
    private double price;
    private Integer qty;
}
