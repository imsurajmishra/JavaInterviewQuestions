package com.asyncq.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    long id;
    long productId;
    long customerId;
}
