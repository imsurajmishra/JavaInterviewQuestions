package com.asyncq.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    long id;
    String name;
    String SKU;
}
