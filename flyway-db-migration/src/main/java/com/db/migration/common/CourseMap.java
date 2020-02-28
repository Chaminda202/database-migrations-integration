package com.db.migration.common;

import com.db.migration.entity.Course;
import com.db.migration.request.CourseRequest;
import com.db.migration.response.CourseResponse;

public class CourseMap {
    private CourseMap(){
    }

    public static Course mapCourseRequest(CourseRequest courseRequest) {
        return Course.builder()
                .name(courseRequest.getName())
                .duration(courseRequest.getDuration())
                .build();
    }

    public static CourseResponse mapCourseResponse(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .duration(course.getDuration())
                .build();
    }
}
