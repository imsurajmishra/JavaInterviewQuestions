package com.asyncq.questions;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.asyncq.dtos.*;
import com.asyncq.utils.Common;

public class CustomerWithOrders {

    public static void main(String[] args) {
        // input data
        Common common = new Common();
        List<Order> orders = common.getOrders();
        List<Customer> customers = common.getCustomers();

        // find all the users with orders count >=50

        // 1: Group all the orders by the customer_id
        Map<Long, List<Order>> customerOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId));

        // 2: Filter all the customer_ids who made 50 or more orders
        List<Long> customerIds = customerOrders.entrySet().stream()
                .filter(a -> a.getValue().size() >= 50)
                .map(Map.Entry::getKey)
                .toList();

        // 3: Map customer_id to Customer in order to return the result.
        List<Customer> targetCustomers = customerIds.stream()
                .map(cid -> customers.stream().filter(c -> c.getId() == cid).findFirst())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        System.out.println(targetCustomers);
    }
}


