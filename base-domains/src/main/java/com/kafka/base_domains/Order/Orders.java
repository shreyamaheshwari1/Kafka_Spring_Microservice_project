package com.kafka.base_domains.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private String OrderId;
    private String name;
    private int qty;
    private double price;
}
