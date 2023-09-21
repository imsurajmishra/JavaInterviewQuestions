package com.asyncq.questions;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.asyncq.dtos.ApplicationLog;
import com.asyncq.utils.Common;

public class PartitionData {

    public static void main(String[] args) {
        Common common = new Common();
        List<ApplicationLog> applicationLogs = common.getSampleLogs();

        Map<String, List<ApplicationLog>> groupedLogs = applicationLogs.stream()
            .collect(
                Collectors.groupingBy(log -> {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    return formatter.format(log.date());
                }
            ));

        groupedLogs.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
