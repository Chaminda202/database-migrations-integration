package com.db.migration.request;

import lombok.Data;

@Data
public class StudentAndCourseRequest {
    private StudentRequest studentRequest;
    private CourseRequest courseRequest;
}
