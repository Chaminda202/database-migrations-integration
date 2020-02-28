package com.db.migration.service;

import com.db.migration.entity.Student;
import com.db.migration.request.StudentAndCourseRequest;
import com.db.migration.response.StudentResponse;

public interface StudentService {
    StudentResponse create(Student student);
    StudentResponse get(Integer id);
    void delete(Integer id);
    StudentResponse update(Integer id, Student student);
    void saveStudentAndCourse(StudentAndCourseRequest studentAndCourseRequest);
}
