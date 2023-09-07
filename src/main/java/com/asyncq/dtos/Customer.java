package com.asyncq.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {
    long id;
    String name;
    long age;
}
