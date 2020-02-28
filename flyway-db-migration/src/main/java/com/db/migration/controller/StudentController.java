package com.db.migration.controller;

import com.db.migration.common.StudentMap;
import com.db.migration.request.StudentAndCourseRequest;
import com.db.migration.request.StudentRequest;
import com.db.migration.response.StudentResponse;
import com.db.migration.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @ApiOperation(value = "Add a Student")
    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest studentRequest){
        return ResponseEntity
                .ok()
                .body(this.studentService.create(StudentMap.mapStudentRequest(studentRequest)));
    }

    @GetMapping
    public ResponseEntity<StudentResponse> get(@RequestParam("id") Integer id){
        return ResponseEntity.ok().body(this.studentService.get(id));
    }

    @PutMapping
    public ResponseEntity<StudentResponse> update(@RequestParam("id") Integer id, @RequestBody StudentRequest studentRequest){
        return ResponseEntity
                .ok()
                .body(this.studentService.update(id, StudentMap.mapStudentRequest(studentRequest)));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("id") Integer id){
        this.studentService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Void> saveStudentAndCourse(@RequestBody StudentAndCourseRequest studentAndCourseRequest) {
        this.studentService.saveStudentAndCourse(studentAndCourseRequest);
        return ResponseEntity
                .noContent()
                .build();
    }
}
