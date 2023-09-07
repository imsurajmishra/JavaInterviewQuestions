package com.asyncq.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class BagOfFruits {

    @Test
    public void test(){
        List<String> fruits = List.of("apple",
                "apple","apple","apple", "apple", "apple",
                "grapes",  "grapes",
                "kiwi","kiwi", "kiwi", "kiwi", "kiwi");
        List<String> expected= List.of("apple", "kiwi");
        long THRESHOLD = 2;
        List<String> actual= solution(fruits, THRESHOLD);
        assertEquals(expected, actual);
    }

    public List<String> solution(List<String> fruits, long THRESHOLD){
        Map<String, Long> countingMap = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        return countingMap.entrySet()
                .stream()
                .filter(a -> a.getValue() > THRESHOLD)
                .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
    }

    // give bag of fruit boxes , find fruits whose count more than 2

    static List<String> fruits = List.of("apple",
            "apple","apple","apple", "apple", "apple",
            "grapes",  "grapes",
            "kiwi","kiwi", "kiwi", "kiwi", "kiwi");
    static long THRESHOLD = 2;

    // output : [apple, kiwi]

    public static void main(String[] args) {
        priorJava8();
        java8Style();
    }

    private static void priorJava8(){
        Map<String, Integer> countingMap = new HashMap<>();
        for(String fruit: fruits){
            countingMap.put(fruit, countingMap.getOrDefault(fruit, 0)+1);
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> fruitCountMap : countingMap.entrySet()){
            if(fruitCountMap.getValue()>THRESHOLD){
                result.add(fruitCountMap.getKey());
            }
        }

        System.out.println("Before java 8");
        System.out.println(result.toString());
    }

    private static void java8Style() {

        Map<String, Long> countingMap = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));


        String[] result = countingMap.entrySet()
                .stream()
                .filter(a -> a.getValue() > THRESHOLD)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        System.out.println("After java 8");
        System.out.println(Arrays.toString(result));
    }
}
