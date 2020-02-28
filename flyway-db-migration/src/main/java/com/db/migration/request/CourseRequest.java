package com.db.migration.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseRequest {
    private String name;
    private Integer duration;
}
