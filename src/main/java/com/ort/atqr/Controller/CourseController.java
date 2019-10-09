package com.ort.atqr.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.Asignature;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    private final CourseService courseService;
    private final ObjectMapper objectMapper;

    @Autowired
    public CourseController(CourseService courseService, ObjectMapper objectMapper) {
        this.courseService = courseService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course){
        Course created = courseService.create(course);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll(){
        List<Course> courses = courseService.getAll().orElse(new ArrayList<>());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Course> assignStudent(@PathVariable Long id, @RequestBody Student student){
        courseService.assignStudent(id, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
