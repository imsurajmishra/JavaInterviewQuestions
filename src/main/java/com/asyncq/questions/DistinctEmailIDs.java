package com.asyncq.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.asyncq.utils.Common;

public class DistinctEmailIDs {

    public static void main(String[] args) {
        Common common = new Common();
        List<String> input = common.getEmailList();
        System.out.println(input);

        List<String> output = solution1(input);

        List<String> output1 = solution2(input);

        List<String> output2 = solution3(input);

        System.out.println(output);
        System.out.println(output1);
        System.out.println(output2);
    }

    public static List<String> solution3(List<String> input) {
        return input.stream()
            .distinct()
            .toList();
    }

    public static List<String> solution2(List<String> input) {
        return new HashSet<>(input).stream().toList();
    }

    public static List<String> solution1(List<String> input) {
        Map<String, Integer> emailMap = new HashMap<>();
        input.forEach(e ->emailMap.putIfAbsent(e, 1));
        return emailMap.keySet().stream().toList();
    }
}
