package com.asyncq.questions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.asyncq.utils.Common;

public class DomainExists {

    public static void main(String[] args) {
        Common common = new Common();
        List<String> domains = common.domains(1000);
        System.out.println(domains);
        List<String> input = List.of(
                "abc.com",
                "1bmdso665z.net",
                "zd9iekl5yq.com",
                "sknzyhxc72.io",
                "pqr.net"
        );

        List<String> output = input.stream()
                .map(d -> domains.stream().filter(d1 -> d1.equals(d)).findAny())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();


        List<String> output1 = input.stream()
                .filter(domains::contains)
                .toList();

        Set<String> domainsSet = new HashSet<String>(domains);
        List<String> output2 = input.stream()
                .filter(domainsSet::contains)
                .toList();

        Map<String, List<String>> groupedByDomains = domains.stream()
                .collect(Collectors.groupingBy(d -> d.substring(d.lastIndexOf("."), d.length())));
        System.out.println(groupedByDomains);

        List<String> output3 = input.stream()
                .filter(d -> {
                    String tld = d.substring(d.lastIndexOf("."), d.length());
                    return groupedByDomains.containsKey(tld) && groupedByDomains.get(tld).contains(d);
                })
                .toList();

        System.out.println(output);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
    }
}
