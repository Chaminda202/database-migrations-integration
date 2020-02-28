package com.db.migration.service.impl;

import com.db.migration.common.CourseMap;
import com.db.migration.entity.Course;
import com.db.migration.repository.CourseRepository;
import com.db.migration.response.CourseResponse;
import com.db.migration.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public CourseResponse create(Course course){
        //final Course resp = this.courseRepository.save(course);
        //throw new Exception();
        return CourseMap
                .mapCourseResponse(this.courseRepository.save(course));
    }

    @Override
    public CourseResponse get(Integer id) {
        final Optional<Course> course = this.courseRepository.findById(id);
        if(course.isPresent())
            return CourseMap
                    .mapCourseResponse(course.get());
        return new CourseResponse();
    }

    @Override
    public void delete(Integer id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public CourseResponse update(Integer id, Course course) {
        final Optional<Course> optionalCourse = this.courseRepository.findById(id);
        if (optionalCourse.isPresent())
            return CourseMap
                    .mapCourseResponse(this.courseRepository.save(course));
        return new CourseResponse();
    }
}
