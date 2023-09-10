package com.asyncq.questions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompressionTarget {

    public static void main(String[] args) {
        List<Integer> dataPoints = IntStream.rangeClosed(1, 100)
            .mapToObj(i -> new Random().nextInt(1, 10))
            .toList();
        System.out.println(dataPoints.size());
        System.out.println(dataPoints);

        solution(dataPoints);
    }

    public static void solution(List<Integer> dataPoints) {
        Map<Integer, Long> groupedDataPoints = dataPoints.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(groupedDataPoints);

        List<Integer> targetDataPoints = groupedDataPoints.entrySet()
            .stream()
            .filter((e) -> (e.getValue()
                .floatValue() / dataPoints.size()) > 0.10)
            .map(Map.Entry::getKey)
            .toList();

        System.out.println(targetDataPoints);
    }
}
