package com.db.migration.controller;

import com.db.migration.common.CourseMap;
import com.db.migration.request.CourseRequest;
import com.db.migration.response.CourseResponse;
import com.db.migration.service.CourseService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/courses")
public class CourseController {
    private CourseService courseService;

    @ApiOperation(value = "Add a Course")
    @PostMapping
    public ResponseEntity<CourseResponse> create(@RequestBody CourseRequest courseRequest){
        return ResponseEntity
                .ok()
                .body(this.courseService.create(CourseMap.mapCourseRequest(courseRequest)));
    }

    @ApiOperation(value = "Get a Course by Id")
    @GetMapping
    public ResponseEntity<CourseResponse> get(@RequestParam("id") Integer id){
        return ResponseEntity.ok().body(this.courseService.get(id));
    }

    @ApiOperation(value = "Update a Course")
    @PutMapping
    public ResponseEntity<CourseResponse> update(@RequestParam("id") Integer id, @RequestBody CourseRequest courseRequest){
        return ResponseEntity
                .ok()
                .body(this.courseService.update(id, CourseMap.mapCourseRequest(courseRequest)));
    }

    @ApiOperation(value = "Delete a Course")
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("id") Integer id){
        this.courseService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
