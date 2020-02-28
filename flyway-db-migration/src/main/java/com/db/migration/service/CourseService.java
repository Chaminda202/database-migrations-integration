package com.db.migration.service;

import com.db.migration.entity.Course;
import com.db.migration.response.CourseResponse;

public interface CourseService {
    CourseResponse create(Course course);
    CourseResponse get(Integer id);
    void delete(Integer id);
    CourseResponse update(Integer id, Course course);
}
