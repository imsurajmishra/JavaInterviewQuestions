package com.asyncq.dtos;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.Data;

public record ApplicationLog(String id, String message, List<String> tags, Date date) {
}
