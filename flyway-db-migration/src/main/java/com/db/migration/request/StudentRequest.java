package com.db.migration.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentRequest {
    private String name;
    private String occupation;
    private BigDecimal salary;
    private Integer age;
}
