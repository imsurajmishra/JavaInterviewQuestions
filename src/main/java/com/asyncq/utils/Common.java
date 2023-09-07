package com.asyncq.utils;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.asyncq.dtos.*;

public class Common {

    public List<Order> getOrders() {
        List<Product> productList = getProducts();
        List<Customer> customers = getCustomers();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Order> orders = IntStream.rangeClosed(1, 100)
            .mapToObj(i -> customers.stream()
                .map(c -> new Order(atomicInteger.incrementAndGet(),
                      productList.get(
                      new Random().nextInt(0, productList.size() - 1)).getId(),
                      c.getId()
                      )
                ).toList()
            )
            .flatMap(List::stream)
            .collect(Collectors.toList());

        IntStream.rangeClosed(1,300)
                .forEach(orders::remove);
        return orders;
    }

    public  List<Customer> getCustomers() {
        String[] names = {"sam","lee", "jane", "jose", "shimy", "nita", "resh", "amy", "tina", "tee"};
        return IntStream.rangeClosed(1,10)
                .mapToObj(i-> new Customer(i,names[i-1], new Random().nextInt(100)+20))
                .toList();
    }

    public static List<Product> getProducts() {
        String[] names = { "TV", "Laptop", "Phone", "Chair"};
        return IntStream.rangeClosed(1,4)
                .mapToObj(i-> new Product(i,names[i-1], UUID.randomUUID().toString()))
                .toList();
    }


    public  List<String> domains(int size) {
        List<String> topLevelDomain = List.of(".com", ".net", ".io", ".org");
        List<String> domains = IntStream.rangeClosed(1, size)
                .mapToObj(i -> getDomainName(topLevelDomain))
                .collect(Collectors.toList());
        domains.add("pqr.net");
        domains.add("abc.com");

        return domains;
    }

    private  String getDomainName(List<String> tlds){
        String tld = tlds.get(new Random().nextInt(tlds.size() - 1));

        String inputChars = "abcdefghijklmnopqrstuvwxyzz1234567890";
        StringBuilder name = new StringBuilder();
        Random rnd = new Random();
        while (name.length() < 10){
            name.append(inputChars.charAt(rnd.nextInt(inputChars.length()-1)));
        }

        return name.toString() + tld;
    }
}

