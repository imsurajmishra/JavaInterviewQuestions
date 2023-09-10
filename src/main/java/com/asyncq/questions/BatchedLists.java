package com.asyncq.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class BatchedLists {

    public static void main(String[] args) {
        List<Integer> ids = IntStream.rangeClosed(1, 10)
            .mapToObj(i -> new Random().nextInt(100_000))
            .toList();

        System.out.println(ids);

        List<List<Integer>> batchedIds = solution(ids, 3);

        System.out.println(batchedIds.size());
        batchedIds.forEach(System.out::println);
    }

    public static List<List<Integer>> solution(List<Integer> ids, int batch_size){
        int start = 0;
        List<List<Integer>> batchedList = new ArrayList<>();
        while (start < ids.size()){
            batchedList.add(
                ids.subList(start, Math.min(ids.size(), start + batch_size))
            );
            start+=batch_size;
        }
        return batchedList;
    }
}
